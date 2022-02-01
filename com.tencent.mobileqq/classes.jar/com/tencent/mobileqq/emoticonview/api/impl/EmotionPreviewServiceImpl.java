package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import com.tencent.mobileqq.emoticonview.IPreviewThumbAdapter;
import com.tencent.mobileqq.emoticonview.IPreviewThumbAdapter.IThumbItemClickListener;
import com.tencent.mobileqq.emoticonview.PreviewThumbAdapter;
import com.tencent.mobileqq.emoticonview.api.IEmotionPreviewService;

public class EmotionPreviewServiceImpl
  implements IEmotionPreviewService
{
  public IPreviewThumbAdapter createPreviewThumbAdapter(Context paramContext, IPreviewThumbAdapter.IThumbItemClickListener paramIThumbItemClickListener)
  {
    return new PreviewThumbAdapter(paramContext, paramIThumbItemClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.EmotionPreviewServiceImpl
 * JD-Core Version:    0.7.0.1
 */