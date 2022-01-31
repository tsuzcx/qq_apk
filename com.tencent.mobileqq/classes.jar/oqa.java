import com.tencent.av.core.VcSystemInfo;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;
import com.tencent.biz.qqstory.takevideo.rmw.RMWLog;
import com.tencent.biz.qqstory.takevideo.rmw.RMWService;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;

public class oqa
  extends Thread
{
  public oqa(RMWService paramRMWService) {}
  
  public void run()
  {
    RMWLog.a("RMWService", "preload AVCodec - start -");
    VideoEnvironment.a("AVCodec", null, true);
    RMWLog.a("RMWService", "preload AVCodec - end -");
    RMWLog.a("RMWService", "preload PtvFilterSoLoad - start -");
    PtvFilterSoLoad.a(VideoEnvironment.a(), false);
    RMWLog.a("RMWService", "preload PtvFilterSoLoad - end -");
    RMWLog.a("RMWService", "preInit DoodleEmojiManager - start -");
    ((DoodleEmojiManager)SuperManager.a(8)).a(this.a);
    RMWLog.a("RMWService", "preInit DoodleEmojiManager - end -");
    RMWLog.a("RMWService", "preInit HwEnvData.supportHardWareCodec - start -");
    HwEnvData.a();
    RMWLog.a("RMWService", "preInit HwEnvData.supportHardWareCodec - end -");
    RMWLog.a("RMWService", "preInit VcSystemInfo.getCpuInfo - start -");
    VcSystemInfo.a();
    RMWLog.a("RMWService", "preInit VcSystemInfo.getCpuInfo - end -");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oqa
 * JD-Core Version:    0.7.0.1
 */