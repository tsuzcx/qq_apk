package com.tencent.mobileqq.vas.VasResEngine;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import bdhb;
import bdvd;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class VasResController$2
  implements Runnable
{
  public VasResController$2(bdvd parambdvd, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject1 = new File(this.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!((File)localObject1).exists()) || (!((File)localObject1).isDirectory())) {
      if (QLog.isColorLevel()) {
        QLog.d("VasResController", 2, "SignatureView DynamicItem png file path error.");
      }
    }
    do
    {
      return;
      localObject1 = bdhb.a(this.jdField_a_of_type_JavaLangString);
    } while (((ArrayList)localObject1).size() <= 0);
    String[] arrayOfString = new String[((ArrayList)localObject1).size()];
    Object localObject2 = new StringBuilder();
    StringBuilder localStringBuilder = ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString).append(File.separator);
    if (((String)((ArrayList)localObject1).get(0)).contains(".9.png")) {}
    for (localObject1 = "%d.9.png";; localObject1 = "%d.png")
    {
      localStringBuilder.append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        arrayOfString[i] = String.format((String)localObject1, new Object[] { Integer.valueOf(i + 1) });
        i += 1;
      }
    }
    localObject1 = bdvd.a(this.this$0).obtainMessage();
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("type", 1);
    ((Bundle)localObject2).putStringArray("pngs", arrayOfString);
    ((Bundle)localObject2).putInt("interval", this.jdField_a_of_type_Int);
    ((Bundle)localObject2).putInt("repeatTimes", this.b);
    ((Message)localObject1).setData((Bundle)localObject2);
    ((Message)localObject1).what = 10001;
    bdvd.a(this.this$0).sendMessage((Message)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasResEngine.VasResController.2
 * JD-Core Version:    0.7.0.1
 */