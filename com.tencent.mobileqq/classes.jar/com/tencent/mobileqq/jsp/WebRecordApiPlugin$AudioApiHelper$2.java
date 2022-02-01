package com.tencent.mobileqq.jsp;

import avqv;
import bgjb;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WebRecordApiPlugin$AudioApiHelper$2
  implements Runnable
{
  public WebRecordApiPlugin$AudioApiHelper$2(avqv paramavqv, String paramString) {}
  
  public void run()
  {
    Object localObject1 = new File(this.jdField_a_of_type_JavaLangString);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int i = 0;
        for (;;)
        {
          if (i < localObject1.length)
          {
            Object localObject2 = localObject1[i].getName();
            String str = this.jdField_a_of_type_JavaLangString + (String)localObject2;
            localObject2 = localObject2.split("\\.")[0];
            Object localObject3 = new SimpleDateFormat("yyyyMMddHHmmssSS");
            try
            {
              localObject2 = ((SimpleDateFormat)localObject3).parse((String)localObject2);
              localObject3 = Calendar.getInstance();
              ((Calendar)localObject3).set(11, 0);
              ((Calendar)localObject3).set(13, 0);
              ((Calendar)localObject3).set(12, 0);
              ((Calendar)localObject3).set(14, 0);
              if (((Date)localObject2).before(((Calendar)localObject3).getTime()))
              {
                localObject1[i].delete();
                bgjb.a(this.jdField_a_of_type_Avqv.a, str);
              }
              i += 1;
            }
            catch (ParseException localParseException)
            {
              for (;;)
              {
                localParseException.printStackTrace();
              }
            }
          }
        }
      }
      long l = System.currentTimeMillis();
      localObject1 = new SimpleDateFormat("yyyyMMdd").format(new Date(l));
      bgjb.a(this.jdField_a_of_type_Avqv.a, "LAST_DELETE_TIME", (String)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.WebRecordApiPlugin.AudioApiHelper.2
 * JD-Core Version:    0.7.0.1
 */