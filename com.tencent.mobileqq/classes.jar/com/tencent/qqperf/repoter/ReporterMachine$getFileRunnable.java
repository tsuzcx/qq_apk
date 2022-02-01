package com.tencent.qqperf.repoter;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

class ReporterMachine$getFileRunnable
  implements Runnable
{
  String a = Environment.getExternalStorageDirectory().getPath();
  String b = "/Tencent";
  String c = "/tencent";
  String d = "/MobileQQ/log/";
  String e = "/Magnifier/dumpfile/";
  String f = "/SNGAPM/battery/";
  ArrayList<String> g = new ArrayList(6);
  
  public ReporterMachine$getFileRunnable()
  {
    if (!TextUtils.isEmpty(this.a))
    {
      if (!this.a.endsWith("/"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append("/");
        this.a = ((StringBuilder)localObject).toString();
      }
      Object localObject = this.g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(this.b);
      localStringBuilder.append(this.d);
      ((ArrayList)localObject).add(VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString()));
      localObject = this.g;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(this.b);
      localStringBuilder.append(this.e);
      ((ArrayList)localObject).add(VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString()));
      localObject = this.g;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(this.b);
      localStringBuilder.append(this.f);
      ((ArrayList)localObject).add(VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString()));
      localObject = this.g;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(this.c);
      localStringBuilder.append(this.d);
      ((ArrayList)localObject).add(VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString()));
      localObject = this.g;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(this.c);
      localStringBuilder.append(this.e);
      ((ArrayList)localObject).add(VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString()));
      localObject = this.g;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(this.c);
      localStringBuilder.append(this.f);
      ((ArrayList)localObject).add(VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString()));
    }
  }
  
  public void run()
  {
    Iterator localIterator = this.g.iterator();
    Object localObject;
    int i;
    while (localIterator.hasNext())
    {
      localObject = new File((String)localIterator.next());
      if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
      {
        localObject = ((File)localObject).listFiles();
        if (localObject != null) {
          i = 0;
        }
      }
    }
    while (i < localObject.length)
    {
      String str = localObject[i].getPath();
      if ((str.contains(".txt")) || (str.contains(".zip"))) {}
      try
      {
        ReporterMachine.f().add(str);
        label107:
        i += 1;
        continue;
        return;
      }
      catch (Exception localException)
      {
        break label107;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.repoter.ReporterMachine.getFileRunnable
 * JD-Core Version:    0.7.0.1
 */