package dov.com.qq.im.aeeditor.module.edit;

import NS_QQ_STORY_CLIENT.CLIENT.StBatchGetMusicInfoRsp;
import NS_QQ_STORY_META.META.StMusic;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.module.controlpanel.AEEditorMusicControlPanel;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicAdapter.AEEditorMusicInfo;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper;

class AEEditorVideoEditFragment$22
  implements VSDispatchObserver.onVSRspCallBack<CLIENT.StBatchGetMusicInfoRsp>
{
  AEEditorVideoEditFragment$22(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, VsMusicItemInfo paramVsMusicItemInfo) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CLIENT.StBatchGetMusicInfoRsp paramStBatchGetMusicInfoRsp)
  {
    if ((!paramBoolean) || (paramStBatchGetMusicInfoRsp.vecMusic.size() == 0)) {
      AEQLog.d(AEEditorVideoEditFragment.g(), "[VSDispatchObserver.onVSRspCallBack.onReceive], music - request music detail failed");
    }
    for (;;)
    {
      return;
      int i = 0;
      if (i < paramStBatchGetMusicInfoRsp.vecMusic.size())
      {
        paramBaseRequest = (META.StMusic)paramStBatchGetMusicInfoRsp.vecMusic.get(i);
        if ((paramBaseRequest == null) || (TextUtils.isEmpty(paramBaseRequest.strSongMid.get()))) {}
        while (!this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mSongMid.equals(paramBaseRequest.strSongMid.get()))
        {
          i += 1;
          break;
        }
        this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.a(paramBaseRequest);
      }
      for (i = 1; (i != 0) && (AEEditorMusicHelper.a(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo)) && (AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment) != null); i = 0)
      {
        AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment).a(new AEEditorMusicAdapter.AEEditorMusicInfo(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo, false, 2));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment.22
 * JD-Core Version:    0.7.0.1
 */