package dov.com.qq.im.aeeditor.module.text;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tavcut.bean.SolidData;
import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.bean.TextItem;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavcut.session.TAVCutSession;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.weseevideo.model.effect.StickerModel;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.module.filter.AEEditorResourceManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class AEEditorTextPart
{
  private AEEditorTextEditDialog jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextEditDialog;
  private AEEditorTextPart.AEEditorTextDialogListener jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextPart$AEEditorTextDialogListener;
  
  private TextEditorData a(TextEditorData paramTextEditorData)
  {
    if (paramTextEditorData == null) {
      return new TextEditorData();
    }
    Map localMap = paramTextEditorData.getColorList();
    Integer localInteger = Integer.valueOf(0);
    if (!CollectionUtil.isEmptyMap(localMap)) {
      localInteger = (Integer)localMap.get("bgcolor");
    }
    if (localInteger == null) {
      localInteger = Integer.valueOf(0);
    }
    for (;;)
    {
      return new TextEditorData(paramTextEditorData.getUniqueID(), paramTextEditorData.getItemID(), paramTextEditorData.getTextColor(), paramTextEditorData.getContent(), paramTextEditorData.getPagFilePath(), paramTextEditorData.getFontPath(), localInteger.intValue());
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextEditDialog != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextEditDialog.setOnDismissListener(new AEEditorTextPart.2(this));
    }
  }
  
  public TextEditorData a(TAVCutSession paramTAVCutSession, AEEditorTextBean paramAEEditorTextBean, int paramInt)
  {
    String str = AEEditorResourceManager.a().a(paramAEEditorTextBean.fontId, 0);
    StickerModel localStickerModel = new StickerModel();
    Object localObject;
    if ((paramAEEditorTextBean.type != 2) && (paramAEEditorTextBean.type != 3))
    {
      localObject = new ArrayList();
      TextItem localTextItem = new TextItem();
      localTextItem.setText(paramAEEditorTextBean.content);
      localTextItem.setTextColor(paramAEEditorTextBean.textColor);
      localTextItem.setFontPath(str);
      ((ArrayList)localObject).add(localTextItem);
      localStickerModel.setTextItems((List)localObject);
    }
    localStickerModel.setFilePath(paramAEEditorTextBean.pagFilePath);
    localStickerModel.setCenterX(0.5F);
    localStickerModel.setCenterY(0.5F);
    localStickerModel.setScale(paramAEEditorTextBean.scale);
    localStickerModel.setMaxScale(paramAEEditorTextBean.maxScale);
    localStickerModel.setMinScale(paramAEEditorTextBean.minScale);
    localStickerModel.setMaterialId(paramAEEditorTextBean.id);
    try
    {
      localStickerModel.setInteractive(Integer.parseInt(paramAEEditorTextBean.interactive));
      if (paramAEEditorTextBean.type == 3)
      {
        localStickerModel.setType("blur");
        localStickerModel.setEnableRotate(false);
        localStickerModel.setLockRatio(false);
        localStickerModel.setTexturePngPath(paramAEEditorTextBean.blurTexturePath);
        localStickerModel.setTextPngPath(paramAEEditorTextBean.blurTextPath);
      }
      localObject = new SolidData();
      ((SolidData)localObject).setColor(paramAEEditorTextBean.backgroundColor);
      localStickerModel.getSolidItems().put("bgcolor", localObject);
      if ((paramTAVCutSession instanceof TAVCutImageSession))
      {
        ((TAVCutImageSession)paramTAVCutSession).addSticker(paramInt, localStickerModel);
        paramTAVCutSession = new TextEditorData(localStickerModel.getUniqueId(), localStickerModel.getMaterialId(), paramAEEditorTextBean.textColor, paramAEEditorTextBean.content, paramAEEditorTextBean.pagFilePath, str, paramAEEditorTextBean.backgroundColor);
        paramTAVCutSession.setType(paramAEEditorTextBean.type);
        paramTAVCutSession.setInteractive(paramAEEditorTextBean.interactive);
        return paramTAVCutSession;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AEQLog.a("AEEditorTextPart", "exception:", localException);
        continue;
        ThreadManager.getUIHandler().post(new AEEditorTextPart.3(this, paramTAVCutSession, localStickerModel));
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextEditDialog != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextEditDialog.a();
    }
  }
  
  public void a(Context paramContext, TextEditorData paramTextEditorData, TAVCutSession paramTAVCutSession)
  {
    if (paramTextEditorData.getType() == 3) {}
    while ((this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextEditDialog != null) && (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextEditDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextEditDialog = new AEEditorTextEditDialog(paramContext, 2131755011, new AEEditorTextPart.1(this, paramTextEditorData, paramTAVCutSession));
    b();
    paramContext = a(paramTextEditorData);
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextEditDialog.a(paramContext);
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextEditDialog.show();
  }
  
  public void a(TAVCutSession paramTAVCutSession, TextEditorData paramTextEditorData)
  {
    paramTAVCutSession.updateTextSticker(paramTextEditorData);
  }
  
  public void a(AEEditorTextPart.AEEditorTextDialogListener paramAEEditorTextDialogListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextPart$AEEditorTextDialogListener = paramAEEditorTextDialogListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextPart
 * JD-Core Version:    0.7.0.1
 */