package com.tencent.mobileqq.kandian.biz.comment.emotion;

import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.emoticon.IEmotionPanelBuilder;
import com.tencent.mobileqq.emoticon.IEmotionTabCreateListener;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.kandian.biz.comment.emotion.adapter.RIJCommonEmotionAdapter;
import com.tencent.mobileqq.kandian.biz.comment.emotion.adapter.RIJCommonEmotionAdapterParams;
import java.util.List;

public class RIJEmotionPanelBuilder
  implements IEmotionPanelBuilder, IEmotionTabCreateListener
{
  private final RIJCommonEmotionAdapterParams a;
  private final String b;
  private RIJCommonEmotionAdapter c;
  private List d;
  
  public RIJEmotionPanelBuilder(RIJCommonEmotionAdapterParams paramRIJCommonEmotionAdapterParams, String paramString)
  {
    this.a = paramRIJCommonEmotionAdapterParams;
    this.b = paramString;
  }
  
  public void a(List paramList)
  {
    RIJCommonEmotionAdapter localRIJCommonEmotionAdapter = this.c;
    if (localRIJCommonEmotionAdapter != null)
    {
      localRIJCommonEmotionAdapter.setData(paramList);
      return;
    }
    this.d = paramList;
  }
  
  public BaseEmotionAdapter buildComplete()
  {
    this.c = new RIJCommonEmotionAdapter(this.a);
    List localList = this.d;
    if (localList != null) {
      this.c.setData(localList);
    }
    return this.c;
  }
  
  public void buildData() {}
  
  public void buildParams() {}
  
  public void buildView() {}
  
  public void onCreateTabView(View paramView, URLImageView paramURLImageView, ImageView paramImageView, int paramInt)
  {
    paramView = URLDrawable.URLDrawableOptions.obtain();
    paramView = URLDrawable.getDrawable(this.b, paramView);
    paramView.startDownload();
    paramURLImageView.setImageDrawable(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.RIJEmotionPanelBuilder
 * JD-Core Version:    0.7.0.1
 */