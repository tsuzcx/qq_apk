package dov.com.qq.im.aeeditor.module.music;

import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEQLog;

final class AEEditorMusicHelper$5
  implements INetEngineListener
{
  AEEditorMusicHelper$5(AEEditorMusicHelper.MusicDownloadCallback paramMusicDownloadCallback, AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, String paramString) {}
  
  public void onResp(NetResp paramNetResp)
  {
    boolean bool2 = true;
    AEBaseDataReporter localAEBaseDataReporter;
    if ((paramNetResp != null) && (paramNetResp.mResult == 0))
    {
      bool1 = true;
      AEQLog.b("AEEditorMusicHelper", "[downloadMusic], onResp, succeeded=" + bool1);
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicHelper$MusicDownloadCallback != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicHelper$MusicDownloadCallback.a(this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo, bool1, this.jdField_a_of_type_JavaLangString);
      }
      if (paramNetResp != null)
      {
        localAEBaseDataReporter = AEBaseDataReporter.a();
        if (paramNetResp.mResult != 0) {
          break label113;
        }
      }
    }
    label113:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localAEBaseDataReporter.a(bool1, 5, "AEEditorMusicDownload", this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a(), paramNetResp.mErrCode, paramNetResp.reqCost);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper.5
 * JD-Core Version:    0.7.0.1
 */