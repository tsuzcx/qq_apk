package com.tencent.mobileqq.qassistant.wake.aicore;

import android.os.Environment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qassistant.wake.QQAssistantGuiderUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public class WakeDataSaveHelper
{
  public static final String a = QQAssistantGuiderUtil.a;
  public ArrayList<Queue<short[]>> b = new ArrayList(5);
  public ArrayList<AtomicBoolean> c = new ArrayList(5);
  
  WakeDataSaveHelper()
  {
    int i = 0;
    while (i < 5)
    {
      this.b.add(new LinkedList());
      this.c.add(new AtomicBoolean(false));
      i += 1;
    }
  }
  
  private void a(LinkedList<short[]> paramLinkedList, Float paramFloat, int paramInt)
  {
    if (paramLinkedList != null) {
      try
      {
        boolean bool = paramLinkedList.isEmpty();
        if (!bool)
        {
          try
          {
            Object localObject1 = new SimpleDateFormat();
            ((SimpleDateFormat)localObject1).applyPattern("yyyy_MM_dd_HH_mm_ss");
            Object localObject2 = new Date();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(a);
            localStringBuilder.append(((SimpleDateFormat)localObject1).format((Date)localObject2));
            localStringBuilder.append("__");
            localStringBuilder.append((int)(paramFloat.floatValue() * 1000.0F));
            localStringBuilder.append("_");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(".pcm");
            paramFloat = new File(localStringBuilder.toString());
            paramFloat.createNewFile();
            paramFloat = new FileOutputStream(paramFloat);
            localObject1 = new byte[((short[])paramLinkedList.get(0)).length * 2];
            paramLinkedList = paramLinkedList.iterator();
            while (paramLinkedList.hasNext())
            {
              localObject2 = (short[])paramLinkedList.next();
              ByteBuffer.wrap((byte[])localObject1).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put((short[])localObject2);
              paramFloat.write((byte[])localObject1);
            }
            paramFloat.flush();
            paramFloat.close();
          }
          catch (Exception paramLinkedList)
          {
            paramLinkedList.printStackTrace();
          }
          return;
        }
      }
      finally {}
    }
  }
  
  public void a(float paramFloat)
  {
    int i = 0;
    while (i < 5)
    {
      if ((!((AtomicBoolean)this.c.get(i)).get()) && (((Queue)this.b.get(i)).size() == 20))
      {
        ((AtomicBoolean)this.c.get(i)).set(true);
        LinkedList localLinkedList = new LinkedList();
        while (!((Queue)this.b.get(i)).isEmpty()) {
          localLinkedList.add(((Queue)this.b.get(i)).poll());
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getPath());
        ((StringBuilder)localObject).append("/tencent/MobileQQ/HelloQQCache/");
        localObject = new File(((StringBuilder)localObject).toString());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        ThreadManagerV2.excute(new WakeDataSaveHelper.1(this, localLinkedList, paramFloat, i), 64, null, false);
        return;
      }
      i += 1;
    }
  }
  
  public void a(short[] paramArrayOfShort)
  {
    int i = 0;
    while (i < 5)
    {
      if (!((AtomicBoolean)this.c.get(i)).get())
      {
        ((Queue)this.b.get(i)).offer(paramArrayOfShort);
        if (((Queue)this.b.get(i)).size() > 20) {
          ((Queue)this.b.get(i)).poll();
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.aicore.WakeDataSaveHelper
 * JD-Core Version:    0.7.0.1
 */