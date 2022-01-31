package com.tencent.qqlive.tvkplayer.vinfo;

import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter.ITVKVodInfoGetterCallback;
import java.util.ArrayList;
import java.util.Iterator;

class TVKUrlGetter$1
  implements ITVKVodInfoGetter.ITVKVodInfoGetterCallback
{
  TVKUrlGetter$1(TVKUrlGetter paramTVKUrlGetter) {}
  
  public void OnSuccess(int paramInt, TVKVideoInfo paramTVKVideoInfo)
  {
    if (TVKUrlGetter.access$000(this.this$0) == null) {
      return;
    }
    if (paramTVKVideoInfo == null)
    {
      TVKLogUtil.i("MediaPlayerMgr[TVKUrlGetter.java]", "ITVKVodInfoGetter OnFailure , videoinfo is null");
      TVKUrlGetter.access$000(this.this$0).onGetUrlFailed(this.this$0, paramInt, 101, 1, null);
      return;
    }
    if (TextUtils.isEmpty(paramTVKVideoInfo.getPlayUrl()))
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKUrlGetter.java]", "ITVKVodInfoGetter playurl is null");
      TVKUrlGetter.access$000(this.this$0).onGetUrlFailed(this.this$0, paramInt, 101, paramTVKVideoInfo.getCgiCode(), null);
      return;
    }
    Object localObject = paramTVKVideoInfo.getUrlList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TVKVideoInfo.ReferUrl localReferUrl = (TVKVideoInfo.ReferUrl)((Iterator)localObject).next();
      localArrayList1.add(Integer.valueOf(localReferUrl.getVt()));
      localArrayList2.add(localReferUrl.getUrl());
    }
    localObject = new ITVKUrlGetter.ExtraVideoInfo();
    ((ITVKUrlGetter.ExtraVideoInfo)localObject).mBackPlayUrlList = paramTVKVideoInfo.getBackPlayUrl();
    ((ITVKUrlGetter.ExtraVideoInfo)localObject).mVtList = localArrayList1;
    ((ITVKUrlGetter.ExtraVideoInfo)localObject).mReferUrlList = localArrayList2;
    TVKUrlGetter.access$000(this.this$0).onGetUrl(this.this$0, paramInt, paramTVKVideoInfo.getPlayUrl(), (ITVKUrlGetter.ExtraVideoInfo)localObject, paramTVKVideoInfo);
  }
  
  public void onFailure(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    TVKLogUtil.i("MediaPlayerMgr[TVKUrlGetter.java]", "ITVKVodInfoGetter OnFailureerrorCode : " + paramInt2 + "errorCodeStr:" + paramString1);
    if (TVKUrlGetter.access$000(this.this$0) == null) {
      return;
    }
    TVKUrlGetter.access$000(this.this$0).onGetUrlFailed(this.this$0, paramInt1, 101, paramInt2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKUrlGetter.1
 * JD-Core Version:    0.7.0.1
 */