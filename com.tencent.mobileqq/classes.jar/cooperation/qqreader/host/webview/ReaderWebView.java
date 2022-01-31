package cooperation.qqreader.host.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;

public class ReaderWebView
  extends TouchWebView
{
  public ReaderWebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReaderWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public View getCurrentView()
  {
    return this;
  }
  
  public void releaseEngine()
  {
    setPluginEngine(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.host.webview.ReaderWebView
 * JD-Core Version:    0.7.0.1
 */