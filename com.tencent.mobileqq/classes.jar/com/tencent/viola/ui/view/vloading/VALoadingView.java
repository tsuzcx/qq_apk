package com.tencent.viola.ui.view.vloading;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import com.tencent.viola.ui.component.VIndicateLoading;
import com.tencent.viola.ui.view.IVView;
import java.lang.ref.WeakReference;

public class VALoadingView
  extends FrameLayout
  implements IVView<VIndicateLoading>
{
  private ProgressBar mInnerLoadingView;
  private String mLoadingImageBase64Str;
  private VARotateDrawable mRotateDrawable;
  private WeakReference<VIndicateLoading> mWeakReference;
  
  public VALoadingView(Context paramContext, @Nullable String paramString)
  {
    super(paramContext);
    this.mLoadingImageBase64Str = paramString;
    initView(paramContext);
  }
  
  private Drawable base64ToDrawable(String paramString)
  {
    paramString = Base64.decode(paramString, 0);
    if (paramString != null) {
      return new BitmapDrawable(BitmapFactory.decodeByteArray(paramString, 0, paramString.length));
    }
    return null;
  }
  
  private String getLoadingIconBase64Data()
  {
    String str = this.mLoadingImageBase64Str;
    if (str != null) {
      return str;
    }
    return "iVBORw0KGgoAAAANSUhEUgAAAJYAAACWCAMAAAAL34HQAAAAS1BMVEUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADmYDp0AAAAGXRSTlMAJk0zQGZzBCITGh8OCggXSTotRDEqXVVqQNv4pgAABP9JREFUeNrs2ctyozAQheHTGKEbEtgk2O//pJOaSSjUQUiAqGHhb+vNX6ZpjIy3t6vTlshqXItT9JdyuBBHkyt1KZooXIammevMl6UZi6ugAK7iP2ZJ83iYI1m+bT1Ku72aL6/b3iyt6IvSKGpovlX7sgx961BQ30zqPVkdTQyKsc2M2p7laMahlKqZEXJzlqIZg1JEM3fbmqVpTqGUJvBy27IkhVDKqwn027I6CqiCsxXqtmR5ChmUQizruSXLUqhFMSPr+szPailkUY5hWUJmZykKOTAlp+uem6WLThbXNkyblyWJkSjqzrKqvCxDIY2ypGBdJifLUUihtE+WNUazzl0O3JN1PWJZ5y4HrmNZL5/KkopCHifoWVedytIU6nAG92JdOpJ18nLgbnxJxF5f08vh7CURf9n3RZeDGUYx9gpLFMvq145GTNbDsDWKlHFIqMU/T5OxJMTaQZLKeBg6yz6NVk0GB3C6Ca0du6WXgzSZd+lDzN0kuCFcXWuHlCq1HHTuDSFHERgVGB8siSdi+GwpCaZV2XdEJ7hKI/TBfqTGtWvfhbfEecSQ+K120akfscpG51129FubyGLGDxle6OkSeqySU5eNDFVmVicWPS1mXPW9tKba1HgZyc7KF3lEjWJZrzHT3obhQyOD1F2ngyhvaJnKWhDc3aMA2VGMxopBxIwPHKYVxRisuouoXuIYQ1EdEuxTxDw9DpCWYpRDkvwYRcRwznelkcXVIqLFbpIiOolcuhKLHthN0yLrsYUaF9cEdutogWqxkbydn6WxgxvOvYhGYh/zPG/krcN+FIxYjQMMG6pD5F1MKlnqz1AtcVTb/1R5HCItG6qDupq9Om7DXwo93t7e3gqQVPfVor4miZK0pQirEdJDtWLQKMYpWqFcUFUl6GJVlDDrkkOVMEiUoShBYUJVEqEITUkaP+oqqUYRlpIsfvRVUo8iKMPVs/60c7Y7DoJAFKVAguInFN7/VTfpbqnedTRt6jA/PE9wVLzKMCD0IQod8kIDQmicSv34SP1UX1xcXHxGm+7zHLys0shg9C/BySkkuawLQUzZrZv1giSjSNlavWb4Ykl3/HxQIU31Ari7zfofsfZygb/rDWLdxZU+6E2amktRY9IEQ8WFu2bWBKbeMud01xS23qJw1iSh3hK60RRzU6/hoNEU0VVsz6AGe+ixIcUPHzazdO83s7TE7HVa/1PYB5mt9afbHlRuZWXsH8kxNEpRWgmuItqCYWora8lBVfB2wcTThIdD/u4V4IJdEDlaFjEg5o2SyM0uCQtfn1PK3n2nwROJumCGre6bNa9rj+ZB7L/TDosk/YvdtE92+271ptATdb/uveZhpDX0pLC1a/LzsqMpRHdCq/U+AbT6p4FZ4MnG9JPoig+8iNksyMxt/CPerHLrk1mQmDc93MDq9VTMCt4tIj1YBUdo8W6oSaDlFaHFuv1oAiujKC3OzVqOCAdCiyskGiJJCS2mkBgtMO5rMYVEJsKB0GLYZEqEA63FtyXXgNakDrRYQqIFq6SOtFhCImI47GqxbY6HzLqpXS22owTo8U5r0SFx0t3q1L4W2zEVGX7g97V4DvXAN7F9X2s4Kbgy5PuuFseBMfhnmtWh1pnH6yA+PMZVp461zj2MCOm9hxglteijmzhBLSnAhEwKMH2VAkz2pQClETGsCkmCKGU3UValSCnoCV5cbPIDQR5TIrqY83gAAAAASUVORK5CYII=";
  }
  
  private Drawable getLoadingImageDrawable()
  {
    return base64ToDrawable(getLoadingIconBase64Data());
  }
  
  private void initView(Context paramContext)
  {
    paramContext = new ProgressBar(paramContext);
    paramContext.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    VARotateDrawable localVARotateDrawable = new VARotateDrawable(getLoadingImageDrawable());
    paramContext.setIndeterminateDrawable(localVARotateDrawable);
    this.mRotateDrawable = localVARotateDrawable;
    addView(paramContext);
    this.mInnerLoadingView = paramContext;
  }
  
  public void bindComponent(VIndicateLoading paramVIndicateLoading)
  {
    this.mWeakReference = new WeakReference(paramVIndicateLoading);
  }
  
  public VIndicateLoading getComponent()
  {
    WeakReference localWeakReference = this.mWeakReference;
    if (localWeakReference != null) {
      return (VIndicateLoading)localWeakReference.get();
    }
    return null;
  }
  
  public boolean isAnimating()
  {
    VARotateDrawable localVARotateDrawable = this.mRotateDrawable;
    if (localVARotateDrawable != null) {
      return localVARotateDrawable.isRunning();
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    VARotateDrawable localVARotateDrawable = this.mRotateDrawable;
    if (localVARotateDrawable != null) {
      localVARotateDrawable.setBounds(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
  }
  
  public void startAnimating()
  {
    VARotateDrawable localVARotateDrawable = this.mRotateDrawable;
    if (localVARotateDrawable != null) {
      localVARotateDrawable.start();
    }
  }
  
  public void stopAnimating()
  {
    VARotateDrawable localVARotateDrawable = this.mRotateDrawable;
    if (localVARotateDrawable != null) {
      localVARotateDrawable.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.vloading.VALoadingView
 * JD-Core Version:    0.7.0.1
 */