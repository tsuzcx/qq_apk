package com.tencent.plato.sdk.animation;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.utils.AssertUtil;
import com.tencent.plato.core.utils.PLog;
import com.tencent.plato.sdk.utils.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PKeyFrame
{
  private static final String KEYFRAME_FROM = "from";
  private static final String KEYFRAME_PERCENT = "%";
  private static final String KEYFRAME_PREFIX = "@keyframes";
  private static final String KEYFRAME_TO = "to";
  private static final String TAG = "PKeyFrame";
  private List<Frame> mFrames = new ArrayList();
  private String mName;
  private String mRawKeyFrame;
  private IReadableMap mRawKeyFrameMap;
  
  public PKeyFrame(IReadableMap paramIReadableMap)
  {
    this.mRawKeyFrameMap = paramIReadableMap;
    init(this.mRawKeyFrameMap);
  }
  
  public PKeyFrame(String paramString)
  {
    this.mRawKeyFrame = paramString;
    init(this.mRawKeyFrame);
  }
  
  private Float getFramePercent(String paramString)
  {
    paramString = paramString.trim();
    if ((TextUtils.isEmpty(paramString)) || ("from".equals(paramString))) {}
    do
    {
      return Float.valueOf(0.0F);
      if ("to".equals(paramString)) {
        return Float.valueOf(1.0F);
      }
    } while (!paramString.endsWith("%"));
    return Float.valueOf(Integer.parseInt(paramString.substring(0, paramString.indexOf("%"))) * 1.0F / 100.0F);
  }
  
  private void init(IReadableMap paramIReadableMap)
  {
    List localList = paramIReadableMap.names();
    if ((localList != null) && (localList.size() > 0))
    {
      this.mName = ((String)localList.get(0));
      paramIReadableMap = paramIReadableMap.getReadableMap(this.mName);
      localList = paramIReadableMap.names();
      if ((localList != null) && (localList.size() > 0))
      {
        int i = 0;
        while (i < localList.size())
        {
          this.mFrames.add(new Frame((String)localList.get(i), paramIReadableMap.getReadableMap((String)localList.get(i))));
          i += 1;
        }
      }
    }
  }
  
  private void init(String paramString)
  {
    int i = 0;
    boolean bool;
    label111:
    List localList;
    if (!TextUtils.isEmpty(paramString))
    {
      bool = true;
      AssertUtil.Assert(bool, "PKeyFrame parse: null keyframe");
      AssertUtil.Assert(paramString.startsWith("@keyframes"), "PKeyFrame parse: not start with @keyframes");
      this.mName = paramString.substring(paramString.indexOf("@keyframes") + "@keyframes".length(), paramString.indexOf("{")).trim();
      paramString = paramString.substring(paramString.indexOf("{") + 1, paramString.lastIndexOf("}")).trim();
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      String[] arrayOfString = paramString.split("\\}");
      if ((arrayOfString == null) || (arrayOfString.length <= 0)) {
        return;
      }
      int j = arrayOfString.length;
      if (i >= j) {
        return;
      }
      paramString = arrayOfString[i].trim();
      if (!TextUtils.isEmpty(paramString))
      {
        localList = this.mFrames;
        if (!paramString.endsWith("}")) {
          break label176;
        }
      }
    }
    for (;;)
    {
      localList.add(new Frame(paramString));
      i += 1;
      break label111;
      bool = false;
      break;
      label176:
      paramString = paramString + "}";
    }
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public Pair<String, Object> parseTransfrom(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      do
      {
        do
        {
          return null;
          str = paramString.substring(paramString.indexOf("(") + 1, paramString.indexOf(")"));
          if ((!paramString.startsWith("rotateX")) && (!paramString.startsWith("rotateY")) && (!paramString.startsWith("rotateZ")) && (!paramString.startsWith("rotate"))) {
            break;
          }
        } while ((TextUtils.isEmpty(str)) || (!str.endsWith("deg")));
        str = str.substring(0, str.indexOf("deg"));
        if (paramString.startsWith("rotateX")) {
          paramString = "rotateX";
        }
        for (;;)
        {
          return new Pair(paramString, Float.valueOf(Float.parseFloat(str)));
          if (paramString.startsWith("rotateY")) {
            paramString = "rotateY";
          } else if (paramString.startsWith("rotateZ")) {
            paramString = "rotateZ";
          } else {
            paramString = "rotate";
          }
        }
        if ((!paramString.startsWith("scaleX")) && (!paramString.startsWith("scaleY")) && (!paramString.startsWith("scale"))) {
          break;
        }
      } while (TextUtils.isEmpty(str));
      if (paramString.startsWith("scaleX")) {
        paramString = "scaleX";
      }
      for (;;)
      {
        return new Pair(paramString, Float.valueOf(Float.parseFloat(str)));
        if (paramString.startsWith("scaleY")) {
          paramString = "scaleY";
        } else {
          paramString = "scale";
        }
      }
      if ((!paramString.startsWith("translateX")) && (!paramString.startsWith("translateY")) && (!paramString.startsWith("translateZ"))) {
        break;
      }
    } while ((TextUtils.isEmpty(str)) || (!str.endsWith("px")));
    if (paramString.startsWith("translateX")) {
      paramString = "translateX";
    }
    for (;;)
    {
      return new Pair(paramString, Float.valueOf(Dimension.parse(str).px));
      if (paramString.startsWith("translateY")) {
        paramString = "translateY";
      } else {
        paramString = "translateZ";
      }
    }
    PLog.e("PKeyFrame", "parseTransform error:" + paramString);
    return null;
  }
  
  public PropertyValuesHolder[] toPropertyValuesHolder()
  {
    Object localObject3 = new HashMap();
    Object localObject4 = this.mFrames.iterator();
    Object localObject5;
    Object localObject6;
    while (((Iterator)localObject4).hasNext())
    {
      localObject1 = (Frame)((Iterator)localObject4).next();
      localObject5 = getFramePercent(((Frame)localObject1).name);
      localObject6 = ((Frame)localObject1).properties.entrySet().iterator();
      while (((Iterator)localObject6).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject6).next();
        String str = (String)localEntry.getKey();
        localObject2 = (Map)((Map)localObject3).get(str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new LinkedHashMap();
          ((Map)localObject3).put(str, localObject1);
        }
        if (("left".equals(str)) || ("top".equals(str))) {
          ((Map)localObject1).put(localObject5, Float.valueOf(((Dimension)localEntry.getValue()).px));
        } else if ("opacity".equals(str)) {
          ((Map)localObject1).put(localObject5, localEntry.getValue());
        } else if (("rotateX".equals(str)) || ("rotateY".equals(str)) || ("rotateZ".equals(str)) || ("rotate".equals(str))) {
          ((Map)localObject1).put(localObject5, localEntry.getValue());
        } else if (("scaleX".equals(str)) || ("scaleY".equals(str)) || ("scale".equals(str))) {
          ((Map)localObject1).put(localObject5, localEntry.getValue());
        } else if (("translateX".equals(str)) || ("translateY".equals(str)) || ("translateZ".equals(str))) {
          ((Map)localObject1).put(localObject5, localEntry.getValue());
        }
      }
    }
    Object localObject1 = new PropertyValuesHolder[((Map)localObject3).size()];
    int i = 0;
    Object localObject2 = ((Map)localObject3).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (Map.Entry)((Iterator)localObject2).next();
      localObject3 = (String)((Map.Entry)localObject4).getKey();
      localObject5 = (Map)((Map.Entry)localObject4).getValue();
      localObject4 = new Keyframe[((Map)localObject5).size()];
      int j = 0;
      localObject5 = ((Map)localObject5).entrySet().iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (Map.Entry)((Iterator)localObject5).next();
        localObject4[j] = Keyframe.ofObject(((Float)((Map.Entry)localObject6).getKey()).floatValue(), ((Map.Entry)localObject6).getValue());
        j += 1;
      }
      localObject1[i] = PropertyValuesHolder.ofKeyframe((String)localObject3, (Keyframe[])localObject4);
      i += 1;
    }
    return localObject1;
  }
  
  public class Frame
  {
    String name;
    Map<String, Object> properties = new HashMap();
    
    public Frame(String paramString)
    {
      create(paramString);
    }
    
    public Frame(String paramString, IReadableMap paramIReadableMap)
    {
      this.name = paramString;
      this$1 = paramIReadableMap.names();
      if ((PKeyFrame.this != null) && (PKeyFrame.this.size() > 0))
      {
        this$1 = PKeyFrame.this.iterator();
        while (PKeyFrame.this.hasNext())
        {
          paramString = (String)PKeyFrame.this.next();
          create(paramString, paramIReadableMap.getString(paramString, null));
        }
      }
    }
    
    public void create(String paramString)
    {
      boolean bool;
      int i;
      label85:
      Object localObject;
      if (!TextUtils.isEmpty(paramString))
      {
        bool = true;
        AssertUtil.Assert(bool, "Frame error");
        this.name = paramString.substring(0, paramString.indexOf("{")).trim();
        paramString = paramString.substring(paramString.indexOf("{") + 1, paramString.indexOf("}")).trim();
        if (TextUtils.isEmpty(paramString)) {
          return;
        }
        paramString = paramString.split(";");
        if ((paramString == null) || (paramString.length <= 0)) {
          return;
        }
        int j = paramString.length;
        i = 0;
        if (i >= j) {
          return;
        }
        localObject = paramString[i].trim();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split(":");
          if ((localObject != null) && (localObject.length == 2) && (!TextUtils.isEmpty(localObject[0])) && (!TextUtils.isEmpty(localObject[1])))
          {
            localObject[0] = localObject[0].trim();
            localObject[1] = localObject[1].trim();
            if ((!"left".equals(localObject[0])) && (!"top".equals(localObject[0]))) {
              break label227;
            }
            this.properties.put(localObject[0], Dimension.parse(localObject[1]));
          }
        }
      }
      for (;;)
      {
        i += 1;
        break label85;
        bool = false;
        break;
        label227:
        if ("opacity".equals(localObject[0]))
        {
          this.properties.put(localObject[0], Float.valueOf(Float.parseFloat(localObject[1])));
        }
        else if ("transform".equals(localObject[0]))
        {
          localObject = PKeyFrame.this.parseTransfrom(localObject[1]);
          if (localObject != null) {
            this.properties.put(((Pair)localObject).first, ((Pair)localObject).second);
          }
        }
      }
    }
    
    public void create(String paramString1, String paramString2)
    {
      int i = 0;
      boolean bool;
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        bool = true;
        AssertUtil.Assert(bool, "Frame error");
        if (!TextUtils.isEmpty(paramString2)) {
          switch (paramString1.hashCode())
          {
          default: 
            label80:
            i = -1;
            label82:
            switch (i)
            {
            }
            break;
          }
        }
      }
      do
      {
        return;
        bool = false;
        break;
        if (!paramString1.equals("left")) {
          break label80;
        }
        break label82;
        if (!paramString1.equals("top")) {
          break label80;
        }
        i = 1;
        break label82;
        if (!paramString1.equals("opacity")) {
          break label80;
        }
        i = 2;
        break label82;
        if (!paramString1.equals("transform")) {
          break label80;
        }
        i = 3;
        break label82;
        this.properties.put(paramString1, Dimension.parse(paramString2));
        return;
        this.properties.put(paramString1, Float.valueOf(Float.parseFloat(paramString2)));
        return;
        paramString1 = PKeyFrame.this.parseTransfrom(paramString2);
      } while (paramString1 == null);
      this.properties.put(paramString1.first, paramString1.second);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.animation.PKeyFrame
 * JD-Core Version:    0.7.0.1
 */