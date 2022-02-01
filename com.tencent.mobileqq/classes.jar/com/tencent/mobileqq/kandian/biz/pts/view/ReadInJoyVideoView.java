package com.tencent.mobileqq.kandian.biz.pts.view;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeVideoView;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadInJoyVideoView
  extends ViewBase
{
  private NativeVideoView a;
  private String b;
  private String c;
  private String d;
  private String e;
  private int f;
  private int g;
  private String h;
  
  public ReadInJoyVideoView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new NativeVideoView(paramVafContext.getContext());
  }
  
  public NativeVideoView a()
  {
    return this.a;
  }
  
  public void b()
  {
    NativeVideoView localNativeVideoView = this.a;
    if (localNativeVideoView != null) {
      localNativeVideoView.stop();
    }
  }
  
  public int getComMeasuredHeight()
  {
    return this.a.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.a.getComMeasuredWidth();
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.a.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.a.setBackgroundColor(this.mBackground);
    this.a.setCoverUrl(this.b);
    this.a.setPlayIconUrl(this.c);
    this.a.setVideoVid(this.d);
    this.a.setPlayIconSize(this.f, this.g);
    if (!TextUtils.isEmpty(this.e)) {
      this.a.setVideoUrl(this.e);
    }
    try
    {
      this.a.setVideoBusiType(Integer.parseInt(this.h));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.e("ReadInJoyVideoView", 2, localNumberFormatException.getMessage());
    }
    refresh();
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if (paramInt != 1009)
    {
      Object localObject;
      if (paramInt != 1148)
      {
        if (paramInt != 1151)
        {
          if (paramInt != 1153) {
            return super.setAttribute(paramInt, paramObject);
          }
        }
        else if (((paramObject instanceof JSONArray)) && (((JSONArray)paramObject).length() == 2)) {
          try
          {
            localObject = ((JSONArray)paramObject).optString(0);
            paramObject = ((JSONArray)paramObject).optString(1);
            this.d = ((String)localObject);
            this.h = paramObject;
            return true;
          }
          catch (NumberFormatException paramObject)
          {
            paramObject.printStackTrace();
            return false;
          }
        }
        if ((paramObject instanceof JSONObject)) {
          try
          {
            this.a.setReportR5(paramObject.toString());
            paramObject = (JSONObject)paramObject;
            this.a.setDtPgid(paramObject.optString("dt_pgid"));
            return true;
          }
          catch (Exception paramObject)
          {
            QLog.d("ReadInJoyVideoView", 1, paramObject.getMessage());
            return true;
          }
        }
        return false;
      }
      if ((paramObject instanceof JSONArray))
      {
        localObject = (JSONArray)paramObject;
        if (((JSONArray)localObject).length() == 2)
        {
          paramObject = ((JSONArray)localObject).optString(0);
          localObject = ((JSONArray)localObject).optString(1);
          try
          {
            paramInt = Integer.parseInt(paramObject);
            int i = Integer.parseInt((String)localObject);
            this.f = paramInt;
            this.g = i;
            return true;
          }
          catch (Exception paramObject)
          {
            paramObject.printStackTrace();
          }
        }
      }
      return true;
    }
    if ((paramObject instanceof BaseArticleInfo)) {
      this.a.setArticleInfo((AbsBaseArticleInfo)paramObject);
    }
    return true;
  }
  
  protected boolean setAttribute(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    case 1148: 
    case 1151: 
    case 1153: 
    default: 
      return super.setAttribute(paramInt, paramString);
    case 1154: 
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          this.a.setAutoPlayMode(Integer.parseInt(paramString));
          return true;
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
        }
      }
      return false;
    case 1152: 
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          this.a.setPlayMode(Integer.parseInt(paramString));
          return true;
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
        }
      }
      return false;
    case 1150: 
      if (!TextUtils.isEmpty(paramString))
      {
        this.a.setPlayIconVisible("yes".equals(paramString.toLowerCase()));
        return true;
      }
      return false;
    case 1149: 
      this.c = paramString;
      return true;
    case 1147: 
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          this.a.setScaleType(Integer.parseInt(paramString));
          return true;
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
        }
      }
      return false;
    case 1146: 
      if (!TextUtils.isEmpty(paramString))
      {
        this.a.setMute("yes".equals(paramString.toLowerCase()));
        return true;
      }
      return false;
    case 1145: 
      if (!TextUtils.isEmpty(paramString))
      {
        this.a.setLoop("yes".equals(paramString.toLowerCase()));
        return true;
      }
      return false;
    case 1144: 
      this.d = paramString;
      return true;
    case 1143: 
      this.b = paramString;
      return true;
    }
    this.e = paramString;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyVideoView
 * JD-Core Version:    0.7.0.1
 */