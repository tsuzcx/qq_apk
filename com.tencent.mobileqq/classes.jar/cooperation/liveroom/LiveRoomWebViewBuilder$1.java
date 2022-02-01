package cooperation.liveroom;

import abff;
import abfo;
import abgj;
import abgo;
import abhi;
import acyv;
import amsb;
import awgm;
import bimv;
import bimw;
import bitv;
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
    localArrayList.add(new amsb());
    localArrayList.add(new bimv());
    localArrayList.add(new bimw());
    localArrayList.add(new VasWebReport());
    localArrayList.add(new abhi());
    localArrayList.add(new abgo());
    localArrayList.add(new abff());
    localArrayList.add(new abfo());
    localArrayList.add(new bitv());
    localArrayList.add(new awgm());
    localArrayList.add(new OpenCenterPlugin());
    localArrayList.add(new MiniAppPlugin());
    localArrayList.add(new abgj());
    localArrayList.add(new acyv());
    localArrayList.add(new SonicJsPlugin());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomWebViewBuilder.1
 * JD-Core Version:    0.7.0.1
 */