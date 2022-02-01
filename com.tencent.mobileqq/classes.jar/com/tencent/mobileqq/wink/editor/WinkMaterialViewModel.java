package com.tencent.mobileqq.wink.editor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import java.util.List;

public class WinkMaterialViewModel
  extends ViewModel
{
  private MutableLiveData<WinkMaterialVO> mFilterMaterialVOLiveData;
  private Observer<List<MetaCategory>> mFiltersObserver;
  private final boolean mIsImageMode;
  private final int mPhoneLevel;
  private MutableLiveData<WinkMaterialVO> mStickerMaterialVOLiveData;
  private Observer<List<MetaCategory>> mStickersObserver;
  private MutableLiveData<WinkMaterialVO> mTextMaterialVOLiveData;
  private Observer<List<MetaCategory>> mTextsObserver;
  private Observer<List<MetaCategory>> mVideoTemplatesObserver;
  private MutableLiveData<WinkMaterialVO> mVideoTemplatesVOLiveData;
  
  public WinkMaterialViewModel(int paramInt, boolean paramBoolean)
  {
    this.mPhoneLevel = paramInt;
    this.mIsImageMode = paramBoolean;
    initFiltersObserver();
    initStickersObserver();
    initTextsObserver();
    initVideoTemplatesObserver();
  }
  
  private void initFiltersObserver()
  {
    this.mFilterMaterialVOLiveData = new MutableLiveData();
    this.mFiltersObserver = new -..Lambda.WinkMaterialViewModel.LH57_anlOmHihXF-WW6ioKhiQSY(this);
    WinkEditorResourceManager.c().d().observeForever(this.mFiltersObserver);
  }
  
  private void initStickersObserver()
  {
    this.mStickerMaterialVOLiveData = new MutableLiveData();
    this.mStickersObserver = new -..Lambda.WinkMaterialViewModel.pU4E861i7dmsE_U052lljWUd0u4(this);
    WinkEditorResourceManager.c().h().observeForever(this.mStickersObserver);
  }
  
  private void initTextsObserver()
  {
    this.mTextMaterialVOLiveData = new MutableLiveData();
    this.mTextsObserver = new -..Lambda.WinkMaterialViewModel.X5nyw5_7qttcJdeYgC3S-b5JUBo(this);
    WinkEditorResourceManager.c().i().observeForever(this.mTextsObserver);
  }
  
  private void initVideoTemplatesObserver()
  {
    this.mVideoTemplatesVOLiveData = new MutableLiveData();
    this.mVideoTemplatesObserver = new -..Lambda.WinkMaterialViewModel.1EZcP8_HsASg2XJwH2U-c5x33bo(this);
    WinkEditorResourceManager.c().g().observeForever(this.mVideoTemplatesObserver);
  }
  
  public LiveData<WinkMaterialVO> getFilterMaterialVOLiveData()
  {
    return this.mFilterMaterialVOLiveData;
  }
  
  public LiveData<WinkMaterialVO> getStickerMaterialVOLiveData()
  {
    return this.mStickerMaterialVOLiveData;
  }
  
  public LiveData<WinkMaterialVO> getTextMaterialVOLiveData()
  {
    return this.mTextMaterialVOLiveData;
  }
  
  public LiveData<WinkMaterialVO> getVideoTemplatesVOLiveData()
  {
    return this.mVideoTemplatesVOLiveData;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    if (this.mFiltersObserver != null) {
      WinkEditorResourceManager.c().d().removeObserver(this.mFiltersObserver);
    }
    if (this.mStickersObserver != null) {
      WinkEditorResourceManager.c().h().removeObserver(this.mStickersObserver);
    }
    if (this.mTextsObserver != null) {
      WinkEditorResourceManager.c().i().removeObserver(this.mTextsObserver);
    }
    if (this.mVideoTemplatesObserver != null) {
      WinkEditorResourceManager.c().g().removeObserver(this.mVideoTemplatesObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkMaterialViewModel
 * JD-Core Version:    0.7.0.1
 */