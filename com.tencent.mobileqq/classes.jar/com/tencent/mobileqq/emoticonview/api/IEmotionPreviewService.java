package com.tencent.mobileqq.emoticonview.api;

import android.content.Context;
import com.tencent.mobileqq.emoticonview.IPreviewThumbAdapter;
import com.tencent.mobileqq.emoticonview.IPreviewThumbAdapter.IThumbItemClickListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IEmotionPreviewService
  extends QRouteApi
{
  public abstract IPreviewThumbAdapter createPreviewThumbAdapter(Context paramContext, IPreviewThumbAdapter.IThumbItemClickListener paramIThumbItemClickListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IEmotionPreviewService
 * JD-Core Version:    0.7.0.1
 */