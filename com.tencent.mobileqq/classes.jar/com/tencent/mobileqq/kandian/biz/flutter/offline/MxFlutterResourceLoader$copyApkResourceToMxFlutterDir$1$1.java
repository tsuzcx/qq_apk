package com.tencent.mobileqq.kandian.biz.flutter.offline;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MxFlutterResourceLoader$copyApkResourceToMxFlutterDir$1$1
  implements Runnable
{
  public static final 1 a = new 1();
  
  public final void run()
  {
    boolean bool2 = MxFlutterResourceLoader.a(MxFlutterResourceLoader.a);
    boolean bool3 = MxFlutterResourceLoader.b(MxFlutterResourceLoader.a);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("copyApkResourceToMxFlutterDir: ");
    ((StringBuilder)localObject).append("copyMainResult=");
    ((StringBuilder)localObject).append(bool2);
    ((StringBuilder)localObject).append(", copyBizResult=");
    ((StringBuilder)localObject).append(bool3);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool1 = true;
    QLog.d("MxFlutterResourceLoader", 1, (String)localObject);
    localObject = MxFlutterResourceLoader.a;
    if ((!bool2) || (!bool3)) {
      bool1 = false;
    }
    ((MxFlutterResourceLoader)localObject).a(bool1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.flutter.offline.MxFlutterResourceLoader.copyApkResourceToMxFlutterDir.1.1
 * JD-Core Version:    0.7.0.1
 */