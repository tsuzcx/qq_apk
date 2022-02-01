package dov.com.qq.im.ae.gif.giftext.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import dov.com.qq.im.Util;
import dov.com.qq.im.ae.gif.giftext.AEGIFTextColorConfig;
import dov.com.qq.im.ae.gif.giftext.AEGIFTextColorConfig.SmartTextColor;
import dov.com.qq.im.ae.gif.video.PngCreateResult.PngResultItem;
import java.io.File;
import java.util.List;

public class AEGIFTextEditViewModel
  extends ViewModel
{
  private MutableLiveData<AEGIFTextColorConfig.SmartTextColor> a = new MutableLiveData();
  private MutableLiveData<String> b = new MutableLiveData();
  private MutableLiveData<PngCreateResult.PngResultItem> c = new MutableLiveData();
  
  public MutableLiveData<AEGIFTextColorConfig.SmartTextColor> a()
  {
    return this.a;
  }
  
  public void a()
  {
    this.a.postValue(new AEGIFTextColorConfig.SmartTextColor("#ccffffff", "#000000"));
    this.b.postValue("");
  }
  
  public void a(String paramString, int paramInt)
  {
    this.b.postValue(paramString);
    this.a.postValue(AEGIFTextColorConfig.a.get(paramInt));
  }
  
  public void a(String paramString1, String paramString2)
  {
    PngCreateResult.PngResultItem localPngResultItem = new PngCreateResult.PngResultItem();
    String[] arrayOfString = new File(paramString2).list();
    String str = paramString2 + File.separator + "snapshot.png";
    if (arrayOfString.length != 0) {
      Util.a(paramString2 + File.separator + arrayOfString[0], 320, 320, str);
    }
    localPngResultItem.a = paramString2;
    localPngResultItem.b = paramString1;
    localPngResultItem.c = str;
    this.c.postValue(localPngResultItem);
  }
  
  public MutableLiveData<String> b()
  {
    return this.b;
  }
  
  public MutableLiveData<PngCreateResult.PngResultItem> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.viewmodel.AEGIFTextEditViewModel
 * JD-Core Version:    0.7.0.1
 */