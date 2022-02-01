package cooperation.liveroom;

import aarc;
import aarl;
import aasg;
import aasl;
import aatf;
import acll;
import amkw;
import avzm;
import bidt;
import bidu;
import bikp;
import com.tencent.biz.webviewplugin.OpenCenterPlugin;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.sonic.SonicJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.ArrayList;
import java.util.List;

class LiveRoomWebViewBuilder$1
  extends WebAccelerateHelper.CommonJsPluginFactory
{
  LiveRoomWebViewBuilder$1(LiveRoomWebViewBuilder paramLiveRoomWebViewBuilder) {}
  
  public List<WebViewPlugin> getCommonJsPlugin()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new amkw());
    localArrayList.add(new bidt());
    localArrayList.add(new bidu());
    localArrayList.add(new VasWebReport());
    localArrayList.add(new aatf());
    localArrayList.add(new aasl());
    localArrayList.add(new aarc());
    localArrayList.add(new aarl());
    localArrayList.add(new bikp());
    localArrayList.add(new avzm());
    localArrayList.add(new OpenCenterPlugin());
    localArrayList.add(new MiniAppPlugin());
    localArrayList.add(new aasg());
    localArrayList.add(new acll());
    localArrayList.add(new SonicJsPlugin());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomWebViewBuilder.1
 * JD-Core Version:    0.7.0.1
 */