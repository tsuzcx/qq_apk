package cooperation.liveroom;

import airb;
import armm;
import bcbo;
import bcbp;
import bcim;
import com.tencent.biz.webviewplugin.OpenCenterPlugin;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.sonic.SonicJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.ArrayList;
import java.util.List;
import xlb;
import xlk;
import xmf;
import xmk;
import xne;
import zcf;

class LiveRoomWebViewBuilder$1
  extends WebAccelerateHelper.CommonJsPluginFactory
{
  LiveRoomWebViewBuilder$1(LiveRoomWebViewBuilder paramLiveRoomWebViewBuilder) {}
  
  public List<WebViewPlugin> getCommonJsPlugin()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new airb());
    localArrayList.add(new bcbo());
    localArrayList.add(new bcbp());
    localArrayList.add(new VasWebReport());
    localArrayList.add(new xne());
    localArrayList.add(new xmk());
    localArrayList.add(new xlb());
    localArrayList.add(new xlk());
    localArrayList.add(new bcim());
    localArrayList.add(new armm());
    localArrayList.add(new OpenCenterPlugin());
    localArrayList.add(new MiniAppPlugin());
    localArrayList.add(new xmf());
    localArrayList.add(new zcf());
    localArrayList.add(new SonicJsPlugin());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomWebViewBuilder.1
 * JD-Core Version:    0.7.0.1
 */