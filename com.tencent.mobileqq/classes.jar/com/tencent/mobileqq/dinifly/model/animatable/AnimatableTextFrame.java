package com.tencent.mobileqq.dinifly.model.animatable;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.animation.Keyframe;
import com.tencent.mobileqq.dinifly.animation.keyframe.TextKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.DocumentData;
import com.tencent.mobileqq.dinifly.model.DocumentData.Factory;
import java.util.List;
import org.json.JSONObject;

public class AnimatableTextFrame
  extends BaseAnimatableValue<DocumentData, DocumentData>
{
  AnimatableTextFrame(List<Keyframe<DocumentData>> paramList, DocumentData paramDocumentData)
  {
    super(paramList, paramDocumentData);
  }
  
  public TextKeyframeAnimation createAnimation()
  {
    return new TextKeyframeAnimation(this.keyframes);
  }
  
  public static final class Factory
  {
    public static AnimatableTextFrame newInstance(JSONObject paramJSONObject, LottieComposition paramLottieComposition)
    {
      if ((paramJSONObject != null) && (paramJSONObject.has("x"))) {
        paramLottieComposition.addWarning("Lottie doesn't support expressions.");
      }
      paramJSONObject = AnimatableValueParser.newInstance(paramJSONObject, 1.0F, paramLottieComposition, AnimatableTextFrame.ValueFactory.access$000()).parseJson();
      return new AnimatableTextFrame(paramJSONObject.keyframes, (DocumentData)paramJSONObject.initialValue);
    }
  }
  
  private static class ValueFactory
    implements AnimatableValue.Factory<DocumentData>
  {
    private static final ValueFactory INSTANCE = new ValueFactory();
    
    public DocumentData valueFromObject(Object paramObject, float paramFloat)
    {
      return DocumentData.Factory.newInstance((JSONObject)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.animatable.AnimatableTextFrame
 * JD-Core Version:    0.7.0.1
 */