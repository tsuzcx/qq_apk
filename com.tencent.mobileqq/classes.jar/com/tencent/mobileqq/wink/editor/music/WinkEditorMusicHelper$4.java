package com.tencent.mobileqq.wink.editor.music;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;

final class WinkEditorMusicHelper$4
  implements INetEngineListener
{
  WinkEditorMusicHelper$4(WinkEditorMusicHelper.MusicDownloadCallback paramMusicDownloadCallback, WinkEditorMusicInfo paramWinkEditorMusicInfo, String paramString) {}
  
  public void onResp(NetResp paramNetResp)
  {
    boolean bool;
    if ((paramNetResp != null) && (paramNetResp.mResult == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    paramNetResp = new StringBuilder();
    paramNetResp.append("[downloadMusic], onResp, succeeded=");
    paramNetResp.append(bool);
    AEQLog.b("AEEditorMusicHelper", paramNetResp.toString());
    paramNetResp = this.a;
    if (paramNetResp != null) {
      paramNetResp.a(this.b, bool, this.c);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = this.a;
    if (paramNetReq != null) {
      paramNetReq.a(this.b, (int)((float)paramLong1 * 100.0F / (float)paramLong2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper.4
 * JD-Core Version:    0.7.0.1
 */