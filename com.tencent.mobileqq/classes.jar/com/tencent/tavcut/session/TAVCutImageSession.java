package com.tencent.tavcut.session;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.exporter.ImageExportConfig;
import com.tencent.tavcut.exporter.ImageExporter;
import com.tencent.tavcut.view.TAVCutImageView;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.weseevideo.composition.builder.MediaBuilderFactory;
import com.tencent.weseevideo.composition.image.WSImageRender;
import com.tencent.weseevideo.editor.sticker.StickerController;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

public class TAVCutImageSession
  extends TAVCutSession
{
  private static final String TAG = TAVCutImageSession.class.getSimpleName();
  private List<String> imagePaths;
  private SparseArray<WSImageRender> imageRenderers = new SparseArray();
  private SparseArray<WeakReference<TAVCutImageView>> tavCutImageViews = new SparseArray();
  
  private void initMediaModel()
  {
    runTask(new TAVCutImageSession.1(this));
  }
  
  private void initRenderEnvironment(int paramInt)
  {
    StickerController localStickerController = createStickerController();
    this.stickerControllers.put(paramInt, localStickerController);
    MediaBuilderFactory.mediaBuilderAsync((MediaModel)this.mediaModels.get(paramInt), localStickerController, new TAVCutImageSession.3(this, paramInt));
    runOnMainThread(new TAVCutImageSession.4(this, paramInt, localStickerController), true);
  }
  
  public void addSticker(int paramInt, @NonNull StickerModel paramStickerModel)
  {
    runTask(new TAVCutImageSession.14(this, paramInt, paramStickerModel));
  }
  
  public void applyCurrentSticker(int paramInt)
  {
    runTask(new TAVCutImageSession.15(this, paramInt));
  }
  
  public ImageExporter getExporter(ImageExportConfig paramImageExportConfig)
  {
    ImageExporter localImageExporter = new ImageExporter();
    localImageExporter.setContext(this.context);
    localImageExporter.setImageExportConfig(paramImageExportConfig);
    localImageExporter.setMediaModels(this.mediaModels);
    return localImageExporter;
  }
  
  public List<MediaModel> getMediaModels()
  {
    return this.mediaModels;
  }
  
  public void init(Context paramContext)
  {
    this.runAsync = true;
    super.init(paramContext);
    initMediaModel();
  }
  
  public void onDeleteButtonClick(String paramString)
  {
    super.onDeleteButtonClick(paramString);
    render(this.currentIndex);
  }
  
  public void onStickerActive()
  {
    render(this.currentIndex);
  }
  
  public void onStickerResign(TAVSticker paramTAVSticker)
  {
    super.onStickerResign(paramTAVSticker);
    render(this.currentIndex);
  }
  
  public void release()
  {
    runTask(new TAVCutImageSession.17(this));
    super.release();
  }
  
  public void releaseTAVCutImageView(int paramInt)
  {
    runTask(new TAVCutImageSession.5(this, paramInt));
  }
  
  public void removeAIFilter(int paramInt)
  {
    runTask(new TAVCutImageSession.12(this, paramInt));
  }
  
  public void render(int paramInt)
  {
    runTask(new TAVCutImageSession.16(this, paramInt));
  }
  
  public void setAEKitAIFilter(int paramInt1, @Nullable String paramString, float paramFloat1, HashMap<String, String> paramHashMap, int paramInt2, float paramFloat2)
  {
    runTask(new TAVCutImageSession.9(this, paramInt1, paramString, paramFloat1, paramHashMap, paramInt2, paramFloat2));
  }
  
  public void setAIFilter(int paramInt, HashMap<String, String> paramHashMap)
  {
    runTask(new TAVCutImageSession.10(this, paramInt, paramHashMap));
  }
  
  public void setAIFilterAlpha(int paramInt, float paramFloat)
  {
    runTask(new TAVCutImageSession.11(this, paramInt, paramFloat));
  }
  
  public void setCrop(int paramInt, CropConfig paramCropConfig)
  {
    runTask(new TAVCutImageSession.13(this, paramInt, paramCropConfig));
  }
  
  public void setImagePaths(List<String> paramList)
  {
    runTask(new TAVCutImageSession.6(this, paramList));
  }
  
  public void setLutAlpha(int paramInt, float paramFloat)
  {
    runTask(new TAVCutImageSession.8(this, paramInt, paramFloat));
  }
  
  public void setLutImage(int paramInt, @Nullable String paramString)
  {
    runTask(new TAVCutImageSession.7(this, paramInt, paramString));
  }
  
  public void setMediaModels(List<MediaModel> paramList)
  {
    this.mediaModels = paramList;
  }
  
  public void setTAVCutImageView(int paramInt, TAVCutImageView paramTAVCutImageView)
  {
    runTask(new TAVCutImageSession.2(this, paramInt, paramTAVCutImageView));
  }
  
  public void updateTextSticker(TextEditorData paramTextEditorData)
  {
    super.updateTextSticker(paramTextEditorData);
    render(this.currentIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession
 * JD-Core Version:    0.7.0.1
 */