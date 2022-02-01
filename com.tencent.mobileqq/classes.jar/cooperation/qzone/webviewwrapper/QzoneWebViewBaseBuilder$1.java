package cooperation.qzone.webviewwrapper;

import aarc;
import aarl;
import aasg;
import aasl;
import aatf;
import amkw;
import avzm;
import bikp;
import com.tencent.biz.webviewplugin.OpenCenterPlugin;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.util.ArrayList;
import java.util.List;

final class QzoneWebViewBaseBuilder$1
  extends WebAccelerateHelper.CommonJsPluginFactory
{
  public List<WebViewPlugin> getCommonJsPlugin()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new amkw());
    localArrayList.add(new aarc());
    localArrayList.add(new aasl());
    localArrayList.add(new aarl());
    localArrayList.add(new bikp());
    localArrayList.add(new VasWebReport());
    localArrayList.add(new avzm());
    localArrayList.add(new OpenCenterPlugin());
    localArrayList.add(new MiniAppPlugin());
    localArrayList.add(new aasg());
    localArrayList.add(new QzoneWebMusicJsPlugin());
    localArrayList.add(new aatf());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewwrapper.QzoneWebViewBaseBuilder.1
 * JD-Core Version:    0.7.0.1
 */