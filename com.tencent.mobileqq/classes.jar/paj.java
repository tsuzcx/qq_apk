import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeVideoView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONArray;

public class paj
  extends ViewBase
{
  private NativeVideoView a;
  
  public paj(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new NativeVideoView(paramVafContext.getContext());
  }
  
  public int getComMeasuredHeight()
  {
    return this.a.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.a.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.a;
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
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    String str;
    do
    {
      return super.setAttribute(paramInt, paramObject);
      if (((paramObject instanceof JSONArray)) && (((JSONArray)paramObject).length() == 2))
      {
        str = ((JSONArray)paramObject).optString(0);
        paramObject = ((JSONArray)paramObject).optString(1);
      }
      try
      {
        paramInt = Integer.parseInt(str);
        int i = Integer.parseInt(paramObject);
        this.a.setPlayIconSize(paramInt, i);
        return true;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          paramObject.printStackTrace();
        }
      }
    } while ((!(paramObject instanceof JSONArray)) || (((JSONArray)paramObject).length() != 2));
    try
    {
      str = ((JSONArray)paramObject).optString(0);
      paramObject = ((JSONArray)paramObject).optString(1);
      this.a.setVideoVid(str);
      this.a.setVideoBusiType(Integer.parseInt(paramObject));
      return true;
    }
    catch (NumberFormatException paramObject)
    {
      paramObject.printStackTrace();
    }
    return false;
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    case 1136: 
    case 1139: 
    default: 
      return super.setAttribute(paramInt, paramString);
    case 1132: 
      this.a.setVideoVid(paramString);
      return true;
    case 1130: 
      this.a.setVideoUrl(paramString);
      return true;
    case 1131: 
      this.a.setCoverUrl(paramString);
      return true;
    case 1133: 
      if (!TextUtils.isEmpty(paramString))
      {
        this.a.setLoop("yes".equals(paramString.toLowerCase()));
        return true;
      }
      return false;
    case 1134: 
      if (!TextUtils.isEmpty(paramString))
      {
        this.a.setMute("yes".equals(paramString.toLowerCase()));
        return true;
      }
      return false;
    case 1135: 
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          this.a.setScaleType(Integer.parseInt(paramString));
          return true;
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
          return false;
        }
      }
      return false;
    case 1137: 
      this.a.setPlayIconUrl(paramString);
      return true;
    case 1138: 
      if (!TextUtils.isEmpty(paramString))
      {
        this.a.setPlayIconVisible("yes".equals(paramString.toLowerCase()));
        return true;
      }
      return false;
    }
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        this.a.setPlayMode(Integer.parseInt(paramString));
        return true;
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
        return false;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     paj
 * JD-Core Version:    0.7.0.1
 */