package com.tencent.mobileqq.jsp;

import com.tencent.mobileqq.util.SharePreferenceUtils;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class WebRecordApiPlugin$AudioApiHelper$2
  implements Runnable
{
  WebRecordApiPlugin$AudioApiHelper$2(WebRecordApiPlugin.AudioApiHelper paramAudioApiHelper, String paramString) {}
  
  public void run()
  {
    Object localObject1 = new File(this.a);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int i = 0;
        while (i < localObject1.length)
        {
          Object localObject3 = localObject1[i].getName();
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.a);
          ((StringBuilder)localObject2).append((String)localObject3);
          localObject2 = ((StringBuilder)localObject2).toString();
          localObject3 = localObject3.split("\\.")[0];
          Object localObject4 = new SimpleDateFormat("yyyyMMddHHmmssSS");
          try
          {
            localObject3 = ((SimpleDateFormat)localObject4).parse((String)localObject3);
            localObject4 = Calendar.getInstance();
            ((Calendar)localObject4).set(11, 0);
            ((Calendar)localObject4).set(13, 0);
            ((Calendar)localObject4).set(12, 0);
            ((Calendar)localObject4).set(14, 0);
            if (((Date)localObject3).before(((Calendar)localObject4).getTime()))
            {
              localObject1[i].delete();
              SharePreferenceUtils.b(this.b.a, (String)localObject2);
            }
          }
          catch (ParseException localParseException)
          {
            localParseException.printStackTrace();
          }
          i += 1;
        }
      }
      long l = System.currentTimeMillis();
      localObject1 = new SimpleDateFormat("yyyyMMdd").format(new Date(l));
      SharePreferenceUtils.a(this.b.a, "LAST_DELETE_TIME", (String)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.WebRecordApiPlugin.AudioApiHelper.2
 * JD-Core Version:    0.7.0.1
 */