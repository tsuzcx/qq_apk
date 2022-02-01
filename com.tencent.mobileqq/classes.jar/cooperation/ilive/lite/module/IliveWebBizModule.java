package cooperation.ilive.lite.module;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilive.EnterRoomConfig;
import com.tencent.ilive.commonpages.room.VerticalViewPager;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.litepages.room.webmodule.model.RoomExtInfo;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebJsParams;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.framework.room.RoomManager;
import com.tencent.mobileqq.litelivesdk.utils.UriUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.ilive.lite.report.IliveLiteDataReport;
import cooperation.vip.JsonUtil;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class IliveWebBizModule
  extends CustomWebModule
{
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  
  private int a()
  {
    if ((this.roomBizContext != null) && (this.roomBizContext.getEnterRoomInfo() != null)) {
      return this.roomBizContext.getEnterRoomInfo().bootModulesIndex;
    }
    return 0;
  }
  
  private long a()
  {
    if ((this.roomBizContext != null) && (this.roomBizContext.getEnterRoomInfo() != null)) {
      return this.roomBizContext.getEnterRoomInfo().roomId;
    }
    return 0L;
  }
  
  private String a()
  {
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl()))) {
      localObject1 = IliveLiteDataReport.a().a();
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = RoomManager.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl());
      localObject1 = (String)((Map)localObject2).get("roomid");
      localObject2 = (String)((Map)localObject2).get("vid");
      if (QLog.isColorLevel()) {
        QLog.i("IliveWebBizModule", 2, "IliveVid switch current Url id = " + (String)localObject1 + " ， getRoomId = " + a() + " vid = " + (String)localObject2);
      }
      localObject1 = localObject2;
    } while (localObject2 != null);
    return "";
  }
  
  private String b(String paramString)
  {
    long l1 = a();
    String str = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
    long l2 = System.currentTimeMillis();
    str = str + "_" + l1 + "_" + l2;
    paramString = UriUtil.b(paramString, "vid", str);
    if (QLog.isColorLevel()) {
      QLog.i("IliveWebBizModule", 2, "IliveVid report serVid id = " + a() + " vid = " + str + " currentItemShown = " + b());
    }
    if (b()) {
      IliveLiteDataReport.a().a(str);
    }
    return paramString;
  }
  
  private boolean b()
  {
    boolean bool = false;
    int j = a();
    if ((getAudienceRoomPager() != null) && (getAudienceRoomPager().getViewPager() != null)) {}
    for (int i = getAudienceRoomPager().getViewPager().getCurrentItem();; i = 0)
    {
      if (j == i) {
        bool = true;
      }
      return bool;
    }
  }
  
  private void c()
  {
    if ((this.jdField_b_of_type_Long != 0L) && (this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = true;
      IliveLiteDataReport.a().a(this.jdField_b_of_type_Long);
    }
  }
  
  public WebJsParams a(String paramString)
  {
    int i = 0;
    Object localObject3 = (paramString + "/#").split("/");
    if (localObject3.length < 5)
    {
      QLog.e("IliveWebBizModule", 1, "illegal jsbridge:" + paramString);
      return null;
    }
    String str = localObject3[2];
    for (;;)
    {
      int j;
      Object localObject4;
      try
      {
        if (localObject3.length != 5) {
          break label465;
        }
        Object localObject1 = localObject3[3].split("#");
        j = localObject1.length;
        if (j > 1) {}
        try
        {
          j = Integer.parseInt(localObject1[1]);
          long l = j;
          localObject1 = localObject1[0].split("\\?");
          localObject3 = localObject1[0];
          if (localObject1.length <= 1) {
            break label458;
          }
          localObject4 = localObject1[1].split("&");
          localObject1 = localObject3;
          if (localObject4.length <= 0) {
            break label345;
          }
          localObject1 = new ArrayList();
          j = localObject4.length;
          if (i >= j) {
            break label319;
          }
          int k = localObject4[i].indexOf('=');
          if (k != -1)
          {
            if ("mqq_tt".equals(localObject4[i].substring(0, k))) {
              break label577;
            }
            new StringBuilder().append(str).append(".").append((String)localObject3).toString();
            ((List)localObject1).add(URLDecoder.decode(localObject4[i].substring(k + 1)));
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.e("IliveWebBizModule", 1, new Object[] { new StringBuilder("illegal jsbridge[").append(paramString).append("] error:").append(localNumberFormatException.toString()) });
          return null;
        }
        localNumberFormatException.add("");
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      label319:
      Object localObject2 = (String[])localNumberFormatException.toArray(new String[localNumberFormatException.size()]);
      localObject2 = localObject3;
      for (;;)
      {
        label345:
        localObject3 = WebViewPlugin.getJsonFromJSBridge(paramString);
        paramString = new HashMap();
        try
        {
          localObject3 = (HashMap)JsonUtil.a((JSONObject)localObject3);
          if (localObject3 != null)
          {
            localObject3 = ((HashMap)localObject3).entrySet().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (Map.Entry)((Iterator)localObject3).next();
              if (localObject4 != null) {
                paramString.put(((Map.Entry)localObject4).getKey(), ((Map.Entry)localObject4).getValue().toString());
              }
            }
          }
          return new WebJsParams(str, (String)localObject2, paramString);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        label458:
        localObject2 = localJSONException;
        continue;
        label465:
        localObject2 = localJSONException[3];
        try
        {
          Long.parseLong(localJSONException[4]);
          i = localJSONException.length - 6;
          localObject4 = new String[i];
          System.arraycopy(localJSONException, 5, localObject4, 0, i);
          j = localObject4.length;
          i = 0;
          while (i < j)
          {
            localObject4[i] = URLDecoder.decode(localObject4[i]);
            i += 1;
          }
        }
        catch (Exception localException)
        {
          QLog.e("IliveWebBizModule", 1, new Object[] { new StringBuilder("illegal jsbridge[").append(paramString).append("] error:").append(localException.toString()) });
          return null;
        }
      }
      label577:
      i += 1;
    }
  }
  
  public String a(String paramString)
  {
    return paramString;
  }
  
  public void a(RoomExtInfo paramRoomExtInfo)
  {
    super.a(paramRoomExtInfo);
    IliveLiteDataReport.a().a(paramRoomExtInfo);
  }
  
  public String b()
  {
    Object localObject = QzoneConfig.getInstance().getConfig("H5Url", "ilive_enter_room", "https://h5.qzone.qq.com/v2/vip/live/room?inplayer=1");
    EnterRoomConfig localEnterRoomConfig = BusinessManager.a.a();
    if ((localEnterRoomConfig != null) && (localEnterRoomConfig.extData != null))
    {
      String str1 = (String)RoomManager.a(localEnterRoomConfig.extData.getString("mqqschema")).get("closeJump");
      String str2 = UriUtil.b((String)localObject, "closetop", String.valueOf(UIUtil.getStatusBarHeight(this.context) + UIUtil.dp2px(this.context, 9.0F)));
      localObject = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject = "";
      }
      localObject = UriUtil.b(str2, "closejump", String.valueOf(localObject));
      str1 = localEnterRoomConfig.extData.getString("trace_info", "");
      IliveLiteDataReport.a().b(str1);
      localObject = UriUtil.b((String)localObject, "trace_info", String.valueOf(str1));
    }
    for (;;)
    {
      return b(UriUtil.b((String)localObject, "clicktime", System.currentTimeMillis() + ""));
    }
  }
  
  public String c()
  {
    return "https://h5.qzone.qq.com/v2/vip/live/room?inplayer=1&closejump=mqqapi%3A%2F%2Fvaslive%2Fmyshopping%3Fversion%3D1";
  }
  
  public String d()
  {
    return "https://ilive.qq.com/1014/h5/lite_record.html";
  }
  
  public String e()
  {
    return "https://fastest.ilive.qq.com/1014/h5/lite_record.html";
  }
  
  public String f()
  {
    return "https://ilive.qq.com/1014/h5/lite_temporary.html";
  }
  
  public String g()
  {
    return "https://fastest.ilive.qq.com/1014/h5/lite_temporary.html";
  }
  
  public void onActivityResume(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityResume(paramLifecycleOwner);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    if (b()) {
      this.jdField_a_of_type_Boolean = true;
    }
    c();
  }
  
  public void onPageFinished()
  {
    super.onPageFinished();
    if (this.jdField_a_of_type_Long > 0L)
    {
      this.jdField_b_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
      c();
    }
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    super.onSwitchRoom(paramSwitchRoomInfo);
    if (b()) {
      IliveLiteDataReport.a().a(a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveWebBizModule
 * JD-Core Version:    0.7.0.1
 */