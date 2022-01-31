package cooperation.liveroom;

import aiek;
import aqrr;
import bayg;
import bayh;
import bbey;
import com.tencent.biz.webviewplugin.OpenCenterPlugin;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.sonic.SonicJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.ArrayList;
import java.util.List;
import xce;
import xcn;
import xdi;
import xdn;
import xeh;
import ysq;

class LiveRoomWebViewBuilder$1
  extends WebAccelerateHelper.CommonJsPluginFactory
{
  LiveRoomWebViewBuilder$1(LiveRoomWebViewBuilder paramLiveRoomWebViewBuilder) {}
  
  public List<WebViewPlugin> getCommonJsPlugin()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new aiek());
    localArrayList.add(new bayg());
    localArrayList.add(new bayh());
    localArrayList.add(new VasWebReport());
    localArrayList.add(new xeh());
    localArrayList.add(new xdn());
    localArrayList.add(new xce());
    localArrayList.add(new xcn());
    localArrayList.add(new bbey());
    localArrayList.add(new aqrr());
    localArrayList.add(new OpenCenterPlugin());
    localArrayList.add(new MiniAppPlugin());
    localArrayList.add(new xdi());
    localArrayList.add(new ysq());
    localArrayList.add(new SonicJsPlugin());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomWebViewBuilder.1
 * JD-Core Version:    0.7.0.1
 */