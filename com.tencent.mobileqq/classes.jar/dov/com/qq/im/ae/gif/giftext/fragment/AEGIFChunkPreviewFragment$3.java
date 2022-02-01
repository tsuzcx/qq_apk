package dov.com.qq.im.ae.gif.giftext.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.gif.giftext.AEGIFPreviewWrapper;
import dov.com.qq.im.ae.gif.giftext.AEGIFTextColorConfig;
import dov.com.qq.im.ae.gif.giftext.AEGIFTextColorConfig.SmartTextColor;
import dov.com.qq.im.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter;
import dov.com.qq.im.ae.gif.video.PngCreateResult;
import dov.com.qq.im.ae.gif.video.PngCreateResult.PngResultItem;
import dov.com.qq.im.ae.gif.video.PngsCreateWorkingQueue;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class AEGIFChunkPreviewFragment$3
  implements View.OnClickListener
{
  AEGIFChunkPreviewFragment$3(AEGIFChunkPreviewFragment paramAEGIFChunkPreviewFragment) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    AEGIFChunkPreviewFragment.a(this.a, true);
    Set localSet = AEGIFChunkPreviewFragment.a(this.a).a();
    QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, selectedItems = " + localSet);
    Object localObject2 = AEBaseReportParam.a();
    ((AEBaseReportParam)localObject2).k();
    Object localObject1 = new LinkedList();
    int i = 0;
    while (i < AEGIFChunkPreviewFragment.a(this.a).size()) {
      if (!localSet.contains(Integer.valueOf(i)))
      {
        i += 1;
      }
      else
      {
        if (((AEGIFPreviewWrapper)AEGIFChunkPreviewFragment.a(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial != null)
        {
          ((AEBaseReportParam)localObject2).n(((AEGIFPreviewWrapper)AEGIFChunkPreviewFragment.a(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
          ((AEBaseReportParam)localObject2).l("none");
          ((AEBaseReportParam)localObject2).m("none");
          ((List)localObject1).add(((AEGIFPreviewWrapper)AEGIFChunkPreviewFragment.a(this.a).get(i)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
        }
        for (;;)
        {
          AEBaseDataReporter.a().am();
          break;
          if (!((AEGIFPreviewWrapper)AEGIFChunkPreviewFragment.a(this.a).get(i)).jdField_a_of_type_JavaLangString.equals(""))
          {
            ((AEBaseReportParam)localObject2).n("none");
            ((AEBaseReportParam)localObject2).l(((AEGIFTextColorConfig.SmartTextColor)AEGIFTextColorConfig.jdField_a_of_type_JavaUtilList.get(AEGIFTextColorConfig.jdField_a_of_type_ArrayOfInt[(i % AEGIFTextColorConfig.jdField_a_of_type_ArrayOfInt.length)])).jdField_a_of_type_JavaLangString);
            ((AEBaseReportParam)localObject2).m(((AEGIFPreviewWrapper)AEGIFChunkPreviewFragment.a(this.a).get(i)).jdField_a_of_type_JavaLangString);
            ((List)localObject1).add("none");
          }
          else
          {
            ((AEBaseReportParam)localObject2).n("none");
            ((AEBaseReportParam)localObject2).l("none");
            ((AEBaseReportParam)localObject2).m("none");
            ((List)localObject1).add("none");
          }
        }
      }
    }
    localObject2 = new StringBuilder();
    i = 0;
    while (i < ((List)localObject1).size())
    {
      ((StringBuilder)localObject2).append((String)((List)localObject1).get(i));
      if (i != ((List)localObject1).size() - 1) {
        ((StringBuilder)localObject2).append(",");
      }
      i += 1;
    }
    AEBaseDataReporter.a().a(localSet.size(), ((StringBuilder)localObject2).toString());
    AEGIFChunkPreviewFragment.a(this.a).a(false);
    PngCreateResult localPngCreateResult = AEGIFChunkPreviewFragment.a(this.a).a();
    QLog.d("AEGIFChunkPreviewFragment", 4, "save button click, pngDirs = " + localPngCreateResult.a + ", texts = " + localPngCreateResult.b);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    i = j;
    if (i < localPngCreateResult.a.size())
    {
      Integer localInteger = (Integer)localPngCreateResult.d.get(i);
      if (localSet.contains(localInteger))
      {
        if ((i != 0) || (AEGIFChunkPreviewFragment.a(this.a) == null)) {
          break label743;
        }
        localArrayList1.add(AEGIFChunkPreviewFragment.a(this.a).jdField_a_of_type_JavaLangString);
        localArrayList2.add(AEGIFChunkPreviewFragment.a(this.a).b);
        localArrayList3.add(AEGIFChunkPreviewFragment.a(this.a).c);
      }
      for (;;)
      {
        localObject2 = AEGIFChunkPreviewFragment.a(this.a, localInteger.intValue());
        StringBuilder localStringBuilder = new StringBuilder().append("gif^");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject1 = (String)localObject1;
        localArrayList4.add(localObject1);
        AEQLog.b("AEGIFChunkPreviewFragment", "save gif, index=" + i + ", widgetInfo=" + (String)localObject1 + ", originIndex=" + localInteger);
        i += 1;
        break;
        label743:
        localArrayList1.add(localPngCreateResult.a.get(i));
        localArrayList2.add(localPngCreateResult.b.get(i));
        localArrayList3.add(localPngCreateResult.c.get(i));
      }
    }
    AEGIFChunkPreviewFragment.a(this.a, localArrayList1, localArrayList2, localArrayList3, localArrayList4);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment.3
 * JD-Core Version:    0.7.0.1
 */