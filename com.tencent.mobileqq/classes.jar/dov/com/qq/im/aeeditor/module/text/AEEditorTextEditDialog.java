package dov.com.qq.im.aeeditor.module.text;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavsticker.core.TAVFontManager;
import com.tencent.tavsticker.core.TAVPAGFileManager;
import com.tencent.tavsticker.utils.CollectionUtil;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.Map;
import mqq.os.MqqHandler;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGFont;
import org.libpag.PAGLayer;
import org.libpag.PAGSolidLayer;
import org.libpag.PAGText;
import org.libpag.PAGView;

public class AEEditorTextEditDialog
  extends ReportDialog
{
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextEditorData jdField_a_of_type_ComTencentTavcutBeanTextEditorData;
  private AEEditorTextEditDialog.IAEEditorStickerBack jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextEditDialog$IAEEditorStickerBack;
  private String jdField_a_of_type_JavaLangString;
  private PAGView jdField_a_of_type_OrgLibpagPAGView;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private View c;
  
  public AEEditorTextEditDialog(@NonNull Context paramContext, int paramInt, AEEditorTextEditDialog.IAEEditorStickerBack paramIAEEditorStickerBack)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131558597, null);
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextEditDialog$IAEEditorStickerBack = paramIAEEditorStickerBack;
    f();
    setContentView(this.jdField_a_of_type_AndroidViewView);
    AEBaseDataReporter.a().v();
  }
  
  private PAGFont a(TextEditorData paramTextEditorData)
  {
    if (paramTextEditorData == null) {}
    while (TextUtils.isEmpty(paramTextEditorData.getFontPath())) {
      return null;
    }
    return TAVFontManager.getInstance().fontWithPath(paramTextEditorData.getFontPath());
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaLangString = getContext().getResources().getString(2131693930);
    this.jdField_b_of_type_JavaLangString = getContext().getResources().getString(2131691535);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131369611);
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131380358);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131366441));
    this.jdField_a_of_type_OrgLibpagPAGView = ((PAGView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378949));
    this.jdField_a_of_type_OrgLibpagPAGView.play();
    this.jdField_a_of_type_OrgLibpagPAGView.setRepeatCount(0);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new AEEditorTextEditDialog.1(this));
    this.c.setOnClickListener(new AEEditorTextEditDialog.2(this));
    e();
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getContent());
      if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getContent() != null) {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getContent().length());
      }
    }
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData == null) {
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = new TextEditorData();
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_b_of_type_JavaLangString);
    c();
  }
  
  private void b(TextEditorData paramTextEditorData)
  {
    if (paramTextEditorData == null)
    {
      AEQLog.d("AEEditorTextEditDialog", "render PAV data null.");
      return;
    }
    PAGFile localPAGFile = TAVPAGFileManager.getInstance().getPAGFileFromPath(paramTextEditorData.getPagFilePath());
    if (localPAGFile == null)
    {
      AEQLog.d("AEEditorTextEditDialog", "render PAGFile null.");
      return;
    }
    PAGText localPAGText = localPAGFile.getTextData(0);
    if (localPAGText == null)
    {
      AEQLog.d("AEEditorTextEditDialog", "pagText is null.");
      return;
    }
    localPAGText.text = paramTextEditorData.getContent();
    localPAGText.fillColor = this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getTextColor();
    ThreadManager.getUIHandler().post(new AEEditorTextEditDialog.3(this, localPAGFile, paramTextEditorData, localPAGText));
  }
  
  private static void b(Map<String, Integer> paramMap, PAGView paramPAGView)
  {
    PAGComposition localPAGComposition;
    if (paramPAGView != null)
    {
      localPAGComposition = paramPAGView.getComposition();
      if (localPAGComposition == null) {
        AEQLog.d("AEEditorTextEditDialog", "pagComposition null.");
      }
    }
    else
    {
      return;
    }
    int j = localPAGComposition.numLayers();
    int i = 0;
    label31:
    PAGLayer localPAGLayer;
    if (i < j)
    {
      localPAGLayer = localPAGComposition.getLayerAt(i);
      if (localPAGLayer != null) {
        break label56;
      }
    }
    label56:
    label117:
    for (;;)
    {
      i += 1;
      break label31;
      break;
      if ((localPAGLayer.layerType() == 2) && ((localPAGLayer instanceof PAGSolidLayer)))
      {
        if (!CollectionUtil.isEmptyMap(paramMap)) {}
        for (paramPAGView = (Integer)paramMap.get(localPAGLayer.layerName());; paramPAGView = null)
        {
          if (paramPAGView == null) {
            break label117;
          }
          ((PAGSolidLayer)localPAGLayer).setSolidColor(paramPAGView.intValue());
          break;
        }
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData == null)
    {
      AEQLog.d("AEEditorTextEditDialog", "originTextData is null.");
      return;
    }
    String str2 = this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getContent().trim();
    if (TextUtils.isEmpty(str2)) {}
    for (String str1 = this.jdField_b_of_type_JavaLangString;; str1 = this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getContent())
    {
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setContent(str1);
      float f = 1.0F;
      if (TextUtils.isEmpty(str2)) {
        f = 0.5F;
      }
      this.jdField_a_of_type_OrgLibpagPAGView.setAlpha(f);
      b(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
      return;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData == null) {
      AEQLog.d("AEEditorTextEditDialog", "originTextData is null.");
    }
    while (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextEditDialog$IAEEditorStickerBack == null) {
      return;
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextEditDialog$IAEEditorStickerBack.a(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new AEEditorTextEditDialog.4(this));
  }
  
  private void f()
  {
    Window localWindow = getWindow();
    if (localWindow == null) {
      return;
    }
    requestWindowFeature(1);
    localWindow.setBackgroundDrawableResource(17170445);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.alpha = 1.0F;
    localLayoutParams.dimAmount = 1.0F;
    localWindow.setAttributes(localLayoutParams);
  }
  
  public void a()
  {
    c();
  }
  
  public void a(TextEditorData paramTextEditorData)
  {
    this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = paramTextEditorData;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextEditDialog
 * JD-Core Version:    0.7.0.1
 */