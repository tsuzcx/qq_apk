package com.tencent.mobileqq.kandian.biz.flutter;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mobileqq.flutter.launch.DebugInstaller;
import com.tencent.mobileqq.kandian.biz.flutter.offline.MxFlutterResourceLoader;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJFlutterUtils$preDownloadFlutterOnDebugMode$1
  implements Runnable
{
  public static final 1 a = new 1();
  
  public final void run()
  {
    if (DebugInstaller.b())
    {
      MxFlutterResourceLoader.a.e();
      return;
    }
    Toast.makeText((Context)BaseApplication.context, (CharSequence)"安装flutter debug资源失败，请检查是否有外部存储权限", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.flutter.RIJFlutterUtils.preDownloadFlutterOnDebugMode.1
 * JD-Core Version:    0.7.0.1
 */