package dov.com.qq.im.aeeditor.module.text;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tavcut.PagTransformManager;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.module.filter.AEEditorResourceManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class AEEditorTextControlPanel$1
  implements Runnable
{
  AEEditorTextControlPanel$1(AEEditorTextControlPanel paramAEEditorTextControlPanel) {}
  
  public void run()
  {
    Iterator localIterator = AEEditorTextControlPanel.a(this.this$0).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      AEEditorTextBean localAEEditorTextBean = (AEEditorTextBean)localIterator.next();
      if (localAEEditorTextBean.type == 1)
      {
        String str = AEEditorTextControlPanel.a() + AEEditorTextControlPanel.a(this.this$0) + "_" + localAEEditorTextBean.id + ".png";
        localAEEditorTextBean.thumbPath = str;
        AEEditorTextBean.updateTextBeanByStickerConfig(localAEEditorTextBean, AEEditorResourceManager.a().a(AEEditorResourceManager.a().d(localAEEditorTextBean.id)));
        if (localAEEditorTextBean.aiColorIndex >= 0)
        {
          localAEEditorTextBean.backgroundColor = this.this$0.a(localAEEditorTextBean);
          localAEEditorTextBean.textStrokeColor = this.this$0.b(localAEEditorTextBean);
          AEQLog.a("AEEditorTextControlPanel", "[createImageAndUpdate] Intelligent color:" + localAEEditorTextBean.backgroundColor);
        }
        for (;;)
        {
          if (!new File(str).exists()) {
            break label256;
          }
          ThreadManager.getUIHandler().post(new AEEditorTextControlPanel.1.1(this, i));
          i += 1;
          break;
          localAEEditorTextBean.backgroundColor = localAEEditorTextBean.defaultColor;
          localAEEditorTextBean.textStrokeColor = localAEEditorTextBean.textColor;
          AEQLog.a("AEEditorTextControlPanel", "[createImageAndUpdate] default color:" + localAEEditorTextBean.backgroundColor);
        }
        label256:
        AEQLog.a("AEEditorTextControlPanel", "[createImageAndUpdate] pagThumbFilePath:" + localAEEditorTextBean.pagThumbFilePath);
        AEQLog.a("AEEditorTextControlPanel", "[createImageAndUpdate] textStrokeColor:" + localAEEditorTextBean.textStrokeColor);
        AEQLog.a("AEEditorTextControlPanel", "[createImageAndUpdate] backgroundColor:" + localAEEditorTextBean.backgroundColor);
        if ((localAEEditorTextBean.pagThumbFilePath != null) && (new File(localAEEditorTextBean.pagThumbFilePath).exists())) {
          PagTransformManager.getInstance().pagFile2Bitmap(PagTransformManager.getInstance().createThumbPagFile(localAEEditorTextBean.pagThumbFilePath, localAEEditorTextBean.textStrokeColor, localAEEditorTextBean.backgroundColor), new AEEditorTextControlPanel.1.2(this, str, i));
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel.1
 * JD-Core Version:    0.7.0.1
 */