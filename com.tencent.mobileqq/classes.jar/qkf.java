import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeVideoView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class qkf
  extends ViewBase
{
  private int jdField_a_of_type_Int;
  private NativeVideoView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  public qkf(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView = new NativeVideoView(paramVafContext.getContext());
  }
  
  public NativeVideoView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView;
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView.getComMeasuredWidth();
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView.setBackgroundColor(this.mBackground);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView.setCoverUrl(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView.setPlayIconUrl(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView.setVideoVid(this.c);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView.setPlayIconSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    if (!TextUtils.isEmpty(this.d)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView.setVideoUrl(this.d);
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView.setVideoBusiType(Integer.parseInt(this.e));
      refresh();
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("ReadInJoyVideoView", 2, localNumberFormatException.getMessage());
      }
    }
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    String str;
    switch (paramInt)
    {
    case 1145: 
    case 1146: 
    case 1148: 
    default: 
      return super.setAttribute(paramInt, paramObject);
    case 1144: 
      if (((paramObject instanceof JSONArray)) && (((JSONArray)paramObject).length() == 2))
      {
        str = ((JSONArray)paramObject).optString(0);
        paramObject = ((JSONArray)paramObject).optString(1);
      }
      try
      {
        paramInt = Integer.parseInt(str);
        int i = Integer.parseInt(paramObject);
        this.jdField_a_of_type_Int = paramInt;
        this.jdField_b_of_type_Int = i;
        return true;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          paramObject.printStackTrace();
        }
      }
    case 1147: 
      if (((paramObject instanceof JSONArray)) && (((JSONArray)paramObject).length() == 2)) {
        try
        {
          str = ((JSONArray)paramObject).optString(0);
          paramObject = ((JSONArray)paramObject).optString(1);
          this.c = str;
          this.e = paramObject;
          return true;
        }
        catch (NumberFormatException paramObject)
        {
          paramObject.printStackTrace();
          return false;
        }
      }
      break;
    }
    if ((paramObject instanceof JSONObject)) {
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView.setReportR5(paramObject.toString());
        paramObject = (JSONObject)paramObject;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView.setRowKey(paramObject.optString("rowkey"));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView.setDtPgid(paramObject.optString("dt_pgid"));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView.setChannelId(Long.parseLong(paramObject.optString("channel_id")));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView.setPuin(paramObject.optString("puin"));
        return true;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          QLog.d("ReadInJoyVideoView", 1, paramObject.getMessage());
        }
      }
    }
    return false;
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    case 1144: 
    case 1147: 
    case 1149: 
    default: 
      return super.setAttribute(paramInt, paramString);
    case 1140: 
      this.c = paramString;
      return true;
    case 1138: 
      this.d = paramString;
      return true;
    case 1139: 
      this.jdField_a_of_type_JavaLangString = paramString;
      return true;
    case 1141: 
      if (!TextUtils.isEmpty(paramString))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView.setLoop("yes".equals(paramString.toLowerCase()));
        return true;
      }
      return false;
    case 1142: 
      if (!TextUtils.isEmpty(paramString))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView.setMute("yes".equals(paramString.toLowerCase()));
        return true;
      }
      return false;
    case 1143: 
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView.setScaleType(Integer.parseInt(paramString));
          return true;
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
          return false;
        }
      }
      return false;
    case 1145: 
      this.jdField_b_of_type_JavaLangString = paramString;
      return true;
    case 1146: 
      if (!TextUtils.isEmpty(paramString))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView.setPlayIconVisible("yes".equals(paramString.toLowerCase()));
        return true;
      }
      return false;
    case 1148: 
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView.setPlayMode(Integer.parseInt(paramString));
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
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeVideoView.setAutoPlayMode(Integer.parseInt(paramString));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qkf
 * JD-Core Version:    0.7.0.1
 */