package cooperation.liveroom;

import aare;
import akim;
import atda;
import beap;
import beaq;
import behn;
import com.tencent.biz.webviewplugin.OpenCenterPlugin;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.sonic.SonicJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.ArrayList;
import java.util.List;
import yzu;
import zad;
import zay;
import zbd;
import zbx;

class LiveRoomWebViewBuilder$1
  extends WebAccelerateHelper.CommonJsPluginFactory
{
  LiveRoomWebViewBuilder$1(LiveRoomWebViewBuilder paramLiveRoomWebViewBuilder) {}
  
  public List<WebViewPlugin> getCommonJsPlugin()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new akim());
    localArrayList.add(new beap());
    localArrayList.add(new beaq());
    localArrayList.add(new VasWebReport());
    localArrayList.add(new zbx());
    localArrayList.add(new zbd());
    localArrayList.add(new yzu());
    localArrayList.add(new zad());
    localArrayList.add(new behn());
    localArrayList.add(new atda());
    localArrayList.add(new OpenCenterPlugin());
    localArrayList.add(new MiniAppPlugin());
    localArrayList.add(new zay());
    localArrayList.add(new aare());
    localArrayList.add(new SonicJsPlugin());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomWebViewBuilder.1
 * JD-Core Version:    0.7.0.1
 */