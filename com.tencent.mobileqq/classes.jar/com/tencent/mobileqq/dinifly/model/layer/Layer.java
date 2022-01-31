package com.tencent.mobileqq.dinifly.model.layer;

import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.animation.Keyframe;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue.Factory;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTextFrame;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTextFrame.Factory;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTextProperties;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTextProperties.Factory;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTransform;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTransform.Factory;
import com.tencent.mobileqq.dinifly.model.content.ContentModel;
import com.tencent.mobileqq.dinifly.model.content.Mask;
import com.tencent.mobileqq.dinifly.model.content.Mask.Factory;
import com.tencent.mobileqq.dinifly.model.content.ShapeGroup;
import com.tencent.mobileqq.dinifly.utils.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class Layer
{
  private static final String TAG = "Layer";
  private final LottieComposition composition;
  private final List<Keyframe<Float>> inOutKeyframes;
  private final long layerId;
  private final String layerName;
  private final int layerType;
  private final List<Mask> masks;
  private final int matteType;
  private final long parentId;
  private final int preCompHeight;
  private final int preCompWidth;
  @Nullable
  private final String refId;
  private final List<ContentModel> shapes;
  private final int solidColor;
  private final int solidHeight;
  private final int solidWidth;
  private final float startProgress;
  @Nullable
  private final AnimatableTextFrame text;
  @Nullable
  private final AnimatableTextProperties textProperties;
  @Nullable
  private final AnimatableFloatValue timeRemapping;
  private final float timeStretch;
  private final AnimatableTransform transform;
  
  private Layer(List<ContentModel> paramList, LottieComposition paramLottieComposition, String paramString1, long paramLong1, int paramInt1, long paramLong2, @Nullable String paramString2, List<Mask> paramList1, AnimatableTransform paramAnimatableTransform, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, int paramInt6, @Nullable AnimatableTextFrame paramAnimatableTextFrame, @Nullable AnimatableTextProperties paramAnimatableTextProperties, List<Keyframe<Float>> paramList2, int paramInt7, @Nullable AnimatableFloatValue paramAnimatableFloatValue)
  {
    this.shapes = paramList;
    this.composition = paramLottieComposition;
    this.layerName = paramString1;
    this.layerId = paramLong1;
    this.layerType = paramInt1;
    this.parentId = paramLong2;
    this.refId = paramString2;
    this.masks = paramList1;
    this.transform = paramAnimatableTransform;
    this.solidWidth = paramInt2;
    this.solidHeight = paramInt3;
    this.solidColor = paramInt4;
    this.timeStretch = paramFloat1;
    this.startProgress = paramFloat2;
    this.preCompWidth = paramInt5;
    this.preCompHeight = paramInt6;
    this.text = paramAnimatableTextFrame;
    this.textProperties = paramAnimatableTextProperties;
    this.inOutKeyframes = paramList2;
    this.matteType = paramInt7;
    this.timeRemapping = paramAnimatableFloatValue;
  }
  
  LottieComposition getComposition()
  {
    return this.composition;
  }
  
  public long getId()
  {
    return this.layerId;
  }
  
  List<Keyframe<Float>> getInOutKeyframes()
  {
    return this.inOutKeyframes;
  }
  
  public int getLayerType()
  {
    return this.layerType;
  }
  
  List<Mask> getMasks()
  {
    return this.masks;
  }
  
  int getMatteType()
  {
    return this.matteType;
  }
  
  String getName()
  {
    return this.layerName;
  }
  
  long getParentId()
  {
    return this.parentId;
  }
  
  int getPreCompHeight()
  {
    return this.preCompHeight;
  }
  
  int getPreCompWidth()
  {
    return this.preCompWidth;
  }
  
  @Nullable
  String getRefId()
  {
    return this.refId;
  }
  
  List<ContentModel> getShapes()
  {
    return this.shapes;
  }
  
  int getSolidColor()
  {
    return this.solidColor;
  }
  
  int getSolidHeight()
  {
    return this.solidHeight;
  }
  
  int getSolidWidth()
  {
    return this.solidWidth;
  }
  
  float getStartProgress()
  {
    return this.startProgress;
  }
  
  @Nullable
  AnimatableTextFrame getText()
  {
    return this.text;
  }
  
  @Nullable
  AnimatableTextProperties getTextProperties()
  {
    return this.textProperties;
  }
  
  @Nullable
  AnimatableFloatValue getTimeRemapping()
  {
    return this.timeRemapping;
  }
  
  float getTimeStretch()
  {
    return this.timeStretch;
  }
  
  AnimatableTransform getTransform()
  {
    return this.transform;
  }
  
  public String toString()
  {
    return toString("");
  }
  
  public String toString(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append(getName()).append("\n");
    Object localObject1 = this.composition.layerModelForId(getParentId());
    if (localObject1 != null)
    {
      localStringBuilder.append("\t\tParents: ").append(((Layer)localObject1).getName());
      for (localObject1 = this.composition.layerModelForId(((Layer)localObject1).getParentId()); localObject1 != null; localObject1 = this.composition.layerModelForId(((Layer)localObject1).getParentId())) {
        localStringBuilder.append("->").append(((Layer)localObject1).getName());
      }
      localStringBuilder.append(paramString).append("\n");
    }
    if (!getMasks().isEmpty()) {
      localStringBuilder.append(paramString).append("\tMasks: ").append(getMasks().size()).append("\n");
    }
    if ((getSolidWidth() != 0) && (getSolidHeight() != 0)) {
      localStringBuilder.append(paramString).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", new Object[] { Integer.valueOf(getSolidWidth()), Integer.valueOf(getSolidHeight()), Integer.valueOf(getSolidColor()) }));
    }
    if (!this.shapes.isEmpty())
    {
      localStringBuilder.append(paramString).append("\tShapes:\n");
      localObject1 = this.shapes.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        localStringBuilder.append(paramString).append("\t\t").append(localObject2).append("\n");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static class Factory
  {
    public static Layer newInstance(LottieComposition paramLottieComposition)
    {
      Rect localRect = paramLottieComposition.getBounds();
      return new Layer(Collections.emptyList(), paramLottieComposition, "root", -1L, 0, -1L, null, Collections.emptyList(), AnimatableTransform.Factory.newInstance(), 0, 0, 0, 0.0F, 0.0F, localRect.width(), localRect.height(), null, null, Collections.emptyList(), 0, null, null);
    }
    
    public static Layer newInstance(JSONObject paramJSONObject, LottieComposition paramLottieComposition)
    {
      String str1 = paramJSONObject.optString("nm");
      String str2 = paramJSONObject.optString("refId");
      if ((str1.endsWith(".ai")) || (paramJSONObject.optString("cl", "").equals("ai"))) {
        paramLottieComposition.addWarning("Convert your Illustrator layers to shape layers.");
      }
      long l1 = paramJSONObject.optLong("ind");
      int n = 0;
      int k = 0;
      int m = 0;
      int i2 = 0;
      int i1 = 0;
      int i = paramJSONObject.optInt("ty", -1);
      if (i < 6) {}
      int j;
      long l2;
      AnimatableTransform localAnimatableTransform;
      int i3;
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      for (;;)
      {
        j = i;
        if (i == 5)
        {
          j = i;
          if (!Utils.isAtLeastVersion(paramLottieComposition, 4, 8, 0))
          {
            j = 6;
            paramLottieComposition.addWarning("Text is only supported on bodymovin >= 4.8.0");
          }
        }
        l2 = paramJSONObject.optLong("parent", -1L);
        i = n;
        if (j == 1)
        {
          i = (int)(paramJSONObject.optInt("sw") * paramLottieComposition.getDpScale());
          k = (int)(paramJSONObject.optInt("sh") * paramLottieComposition.getDpScale());
          m = Color.parseColor(paramJSONObject.optString("sc"));
        }
        localAnimatableTransform = AnimatableTransform.Factory.newInstance(paramJSONObject.optJSONObject("ks"), paramLottieComposition);
        i3 = paramJSONObject.optInt("tt");
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        localObject1 = paramJSONObject.optJSONArray("masksProperties");
        if (localObject1 == null) {
          break;
        }
        n = 0;
        while (n < ((JSONArray)localObject1).length())
        {
          localArrayList1.add(Mask.Factory.newMask(((JSONArray)localObject1).optJSONObject(n), paramLottieComposition));
          n += 1;
        }
        i = 6;
      }
      ArrayList localArrayList3 = new ArrayList();
      Object localObject1 = paramJSONObject.optJSONArray("shapes");
      if (localObject1 != null)
      {
        n = 0;
        while (n < ((JSONArray)localObject1).length())
        {
          localObject2 = ShapeGroup.shapeItemWithJson(((JSONArray)localObject1).optJSONObject(n), paramLottieComposition);
          if (localObject2 != null) {
            localArrayList3.add(localObject2);
          }
          n += 1;
        }
      }
      localObject1 = null;
      Object localObject2 = null;
      Object localObject3 = paramJSONObject.optJSONObject("t");
      if (localObject3 != null)
      {
        localObject1 = AnimatableTextFrame.Factory.newInstance(((JSONObject)localObject3).optJSONObject("d"), paramLottieComposition);
        localObject2 = AnimatableTextProperties.Factory.newInstance(((JSONObject)localObject3).optJSONArray("a").optJSONObject(0), paramLottieComposition);
      }
      if (paramJSONObject.has("ef")) {
        paramLottieComposition.addWarning("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape.");
      }
      float f2 = (float)paramJSONObject.optDouble("sr", 1.0D);
      float f3 = (float)paramJSONObject.optDouble("st") / paramLottieComposition.getDurationFrames();
      n = i2;
      if (j == 0)
      {
        n = (int)(paramJSONObject.optInt("w") * paramLottieComposition.getDpScale());
        i1 = (int)(paramJSONObject.optInt("h") * paramLottieComposition.getDpScale());
      }
      float f4 = (float)paramJSONObject.optLong("ip") / f2;
      float f1 = (float)paramJSONObject.optLong("op") / f2;
      if (f4 > 0.0F) {
        localArrayList2.add(new Keyframe(paramLottieComposition, Float.valueOf(0.0F), Float.valueOf(0.0F), null, 0.0F, Float.valueOf(f4)));
      }
      if (f1 > 0.0F) {}
      for (;;)
      {
        localArrayList2.add(new Keyframe(paramLottieComposition, Float.valueOf(1.0F), Float.valueOf(1.0F), null, f4, Float.valueOf(f1)));
        localArrayList2.add(new Keyframe(paramLottieComposition, Float.valueOf(0.0F), Float.valueOf(0.0F), null, f1, Float.valueOf(3.4028235E+38F)));
        localObject3 = null;
        if (paramJSONObject.has("tm")) {
          localObject3 = AnimatableFloatValue.Factory.newInstance(paramJSONObject.optJSONObject("tm"), paramLottieComposition, false);
        }
        return new Layer(localArrayList3, paramLottieComposition, str1, l1, j, l2, str2, localArrayList1, localAnimatableTransform, i, k, m, f2, f3, n, i1, (AnimatableTextFrame)localObject1, (AnimatableTextProperties)localObject2, localArrayList2, i3, (AnimatableFloatValue)localObject3, null);
        f1 = (float)(paramLottieComposition.getEndFrame() + 1L);
      }
    }
  }
  
  public class LayerType
  {
    public static final int Image = 2;
    public static final int Null = 3;
    public static final int PreComp = 0;
    public static final int Shape = 4;
    public static final int Solid = 1;
    public static final int Text = 5;
    public static final int Unknown = 6;
    
    public LayerType() {}
  }
  
  class MatteType
  {
    public static final int Add = 1;
    public static final int Invert = 2;
    public static final int None = 0;
    public static final int Unknown = 3;
    
    MatteType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.layer.Layer
 * JD-Core Version:    0.7.0.1
 */