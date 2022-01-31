package com.tencent.mobileqq.dinifly.model.content;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.content.Content;
import com.tencent.mobileqq.dinifly.animation.content.RepeaterContent;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue.Factory;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTransform;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTransform.Factory;
import com.tencent.mobileqq.dinifly.model.layer.BaseLayer;
import org.json.JSONObject;

public class Repeater
  implements ContentModel
{
  private final AnimatableFloatValue copies;
  private final String name;
  private final AnimatableFloatValue offset;
  private final AnimatableTransform transform;
  
  Repeater(String paramString, AnimatableFloatValue paramAnimatableFloatValue1, AnimatableFloatValue paramAnimatableFloatValue2, AnimatableTransform paramAnimatableTransform)
  {
    this.name = paramString;
    this.copies = paramAnimatableFloatValue1;
    this.offset = paramAnimatableFloatValue2;
    this.transform = paramAnimatableTransform;
  }
  
  public AnimatableFloatValue getCopies()
  {
    return this.copies;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public AnimatableFloatValue getOffset()
  {
    return this.offset;
  }
  
  public AnimatableTransform getTransform()
  {
    return this.transform;
  }
  
  @Nullable
  public Content toContent(LottieDrawable paramLottieDrawable, BaseLayer paramBaseLayer)
  {
    return new RepeaterContent(paramLottieDrawable, paramBaseLayer, this);
  }
  
  static final class Factory
  {
    static Repeater newInstance(JSONObject paramJSONObject, LottieComposition paramLottieComposition)
    {
      return new Repeater(paramJSONObject.optString("nm"), AnimatableFloatValue.Factory.newInstance(paramJSONObject.optJSONObject("c"), paramLottieComposition, false), AnimatableFloatValue.Factory.newInstance(paramJSONObject.optJSONObject("o"), paramLottieComposition, false), AnimatableTransform.Factory.newInstance(paramJSONObject.optJSONObject("tr"), paramLottieComposition));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.content.Repeater
 * JD-Core Version:    0.7.0.1
 */