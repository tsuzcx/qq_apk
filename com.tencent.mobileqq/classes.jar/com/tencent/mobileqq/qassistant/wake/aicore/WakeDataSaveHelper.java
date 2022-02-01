package com.tencent.mobileqq.qassistant.wake.aicore;

import android.os.Environment;
import com.tencent.mobileqq.app.ThreadManagerV2;
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
  public static final String a;
  public ArrayList<Queue<short[]>> a;
  public ArrayList<AtomicBoolean> b = new ArrayList(5);
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + "/tencent/MobileQQ/HelloQQCache/";
  }
  
  WakeDataSaveHelper()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    int i = 0;
    while (i < 5)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(new LinkedList());
      this.b.add(new AtomicBoolean(false));
      i += 1;
    }
  }
  
  private void a(LinkedList<short[]> paramLinkedList, Float paramFloat, int paramInt)
  {
    if (paramLinkedList != null) {}
    for (;;)
    {
      try
      {
        boolean bool = paramLinkedList.isEmpty();
        if (bool) {
          return;
        }
        try
        {
          Object localObject1 = new SimpleDateFormat();
          ((SimpleDateFormat)localObject1).applyPattern("yyyy_MM_dd_HH_mm_ss");
          Object localObject2 = new Date();
          paramFloat = new File(jdField_a_of_type_JavaLangString + ((SimpleDateFormat)localObject1).format((Date)localObject2) + "__" + (int)(paramFloat.floatValue() * 1000.0F) + "_" + paramInt + ".pcm");
          paramFloat.createNewFile();
          paramFloat = new FileOutputStream(paramFloat);
          localObject1 = new byte[((short[])paramLinkedList.get(0)).length * 2];
          paramLinkedList = paramLinkedList.iterator();
          if (paramLinkedList.hasNext())
          {
            localObject2 = (short[])paramLinkedList.next();
            ByteBuffer.wrap((byte[])localObject1).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put((short[])localObject2);
            paramFloat.write((byte[])localObject1);
            continue;
          }
        }
        catch (Exception paramLinkedList)
        {
          paramLinkedList.printStackTrace();
        }
        paramFloat.flush();
      }
      finally {}
      paramFloat.close();
    }
  }
  
  public void a(float paramFloat)
  {
    int i = 0;
    for (;;)
    {
      if (i < 5)
      {
        if ((!((AtomicBoolean)this.b.get(i)).get()) && (((Queue)this.jdField_a_of_type_JavaUtilArrayList.get(i)).size() == 20))
        {
          ((AtomicBoolean)this.b.get(i)).set(true);
          LinkedList localLinkedList = new LinkedList();
          while (!((Queue)this.jdField_a_of_type_JavaUtilArrayList.get(i)).isEmpty()) {
            localLinkedList.add(((Queue)this.jdField_a_of_type_JavaUtilArrayList.get(i)).poll());
          }
          File localFile = new File(Environment.getExternalStorageDirectory().getPath() + "/tencent/MobileQQ/HelloQQCache/");
          if (!localFile.exists()) {
            localFile.mkdirs();
          }
          ThreadManagerV2.excute(new WakeDataSaveHelper.1(this, localLinkedList, paramFloat, i), 64, null, false);
        }
      }
      else {
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
      if (!((AtomicBoolean)this.b.get(i)).get())
      {
        ((Queue)this.jdField_a_of_type_JavaUtilArrayList.get(i)).offer(paramArrayOfShort);
        if (((Queue)this.jdField_a_of_type_JavaUtilArrayList.get(i)).size() > 20) {
          ((Queue)this.jdField_a_of_type_JavaUtilArrayList.get(i)).poll();
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.aicore.WakeDataSaveHelper
 * JD-Core Version:    0.7.0.1
 */