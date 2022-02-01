package cooperation.qzone.webviewwrapper;

import aabq;
import aabz;
import aacu;
import aacz;
import aadt;
import almv;
import autn;
import bgzx;
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
    localArrayList.add(new almv());
    localArrayList.add(new aabq());
    localArrayList.add(new aacz());
    localArrayList.add(new aabz());
    localArrayList.add(new bgzx());
    localArrayList.add(new VasWebReport());
    localArrayList.add(new autn());
    localArrayList.add(new OpenCenterPlugin());
    localArrayList.add(new MiniAppPlugin());
    localArrayList.add(new aacu());
    localArrayList.add(new QzoneWebMusicJsPlugin());
    localArrayList.add(new aadt());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewwrapper.QzoneWebViewBaseBuilder.1
 * JD-Core Version:    0.7.0.1
 */