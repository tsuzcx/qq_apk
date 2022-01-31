import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.openapi.ttpicmodule.PTSegmenter;
import java.util.Iterator;
import java.util.List;

public class lin
{
  public static boolean a()
  {
    boolean bool3 = true;
    Object localObject1 = SdkContext.getInstance().getResources().getPtuFilterResource().getSoPathDir();
    Object localObject2 = SdkContext.getInstance().getResources().getPtuFilterResource().getPortraitPathDir();
    boolean bool1;
    label132:
    long l;
    if ((!axlc.g()) || (AIManager.installDetector(PTSegmenter.class, (String)localObject2, (String)localObject1)))
    {
      bool1 = true;
      bool2 = liq.a().a();
      boolean bool4 = lio.a();
      if (QLog.isColorLevel()) {
        QLog.d("PanoramaAccessManager", 2, "checkPanoramaAccessEnable portraitSo = " + bool1 + "| sensorEnable = " + bool2 + " |DPCEntry = " + bool4);
      }
      if ((!bool1) || (!bool2) || (!bool4)) {
        break label279;
      }
      bool2 = true;
      if (!bool2) {
        return bool2;
      }
      localObject1 = lio.a();
      if (localObject1 == null) {
        break label337;
      }
      l = lio.a();
      localObject1 = ((List)localObject1).iterator();
      bool1 = false;
    }
    label163:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (lip)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PanoramaAccessManager", 2, "checkPanoramaAccessEnable CPUinfo = " + ((lip)localObject2).b + "|" + ((lip)localObject2).a);
        }
        if ((bool1) || (lpz.a(((lip)localObject2).b, ((lip)localObject2).a * 10000, l * 100000000L))) {}
        for (bool1 = true;; bool1 = false)
        {
          break label163;
          bool1 = false;
          break;
          bool2 = false;
          break label132;
        }
      }
    }
    label279:
    if ((bool2) && (bool1)) {}
    for (boolean bool2 = bool3;; bool2 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PanoramaAccessManager", 2, "checkPanoramaAccessEnable isDeviceSupport = " + bool1);
      }
      return bool2;
    }
    label337:
    return false;
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lin
 * JD-Core Version:    0.7.0.1
 */