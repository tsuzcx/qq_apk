import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.VideoPlayControlUtils.1;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeVideoView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class omf
{
  public static void a(View paramView)
  {
    if ((paramView instanceof olz)) {
      ((olz)paramView).a();
    }
  }
  
  public static void a(Container paramContainer)
  {
    paramContainer = paramContainer.getViewIdMapping().entrySet().iterator();
    while (paramContainer.hasNext())
    {
      Object localObject = (Map.Entry)paramContainer.next();
      if ((((Map.Entry)localObject).getValue() instanceof paj))
      {
        localObject = (paj)((Map.Entry)localObject).getValue();
        if ((((paj)localObject).getNativeView() instanceof NativeVideoView)) {
          ((NativeVideoView)((paj)localObject).getNativeView()).a();
        }
      }
    }
  }
  
  public static void a(ListView paramListView)
  {
    a(paramListView, true);
  }
  
  public static void a(ListView paramListView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ThreadManager.getUIHandler().postDelayed(new VideoPlayControlUtils.1(paramListView), 50L);
      return;
    }
    f(paramListView);
  }
  
  public static void b(Container paramContainer)
  {
    paramContainer = paramContainer.getViewIdMapping().entrySet().iterator();
    while (paramContainer.hasNext())
    {
      Object localObject = (Map.Entry)paramContainer.next();
      if ((((Map.Entry)localObject).getValue() instanceof paj))
      {
        localObject = (paj)((Map.Entry)localObject).getValue();
        if ((((paj)localObject).getNativeView() instanceof NativeVideoView)) {
          ((NativeVideoView)((paj)localObject).getNativeView()).F_();
        }
      }
    }
  }
  
  public static void b(ListView paramListView)
  {
    if ((!obz.a(paramListView.getContext())) || (paramListView.getChildCount() <= 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramListView.getChildCount())
      {
        View localView = paramListView.getChildAt(i);
        if ((localView instanceof olz)) {
          ((olz)localView).b();
        }
        i += 1;
      }
    }
  }
  
  public static void c(ListView paramListView)
  {
    if ((!obz.a(paramListView.getContext())) || (paramListView.getChildCount() <= 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramListView.getChildCount())
      {
        View localView = paramListView.getChildAt(i);
        if ((localView instanceof olz)) {
          ((olz)localView).a();
        }
        i += 1;
      }
    }
  }
  
  public static void d(ListView paramListView)
  {
    if ((!obz.a(paramListView.getContext())) || (paramListView.getChildCount() <= 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramListView.getChildCount())
      {
        View localView = paramListView.getChildAt(i);
        if ((localView instanceof olz)) {
          ((olz)localView).c();
        }
        i += 1;
      }
    }
  }
  
  private static void f(ListView paramListView)
  {
    int j = 0;
    int i = 0;
    View localView;
    if (i < paramListView.getChildCount())
    {
      localView = paramListView.getChildAt(i);
      if (((localView instanceof olz)) && (obj.a(localView) >= 80.0F))
      {
        QLog.d("gifvideo.VideoPlayControlUtils", 2, ">= 80f");
        if (!((olz)localView).a()) {}
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        QLog.d("gifvideo.VideoPlayControlUtils", 2, "item to play: " + i);
        for (;;)
        {
          if (j < paramListView.getChildCount())
          {
            localView = paramListView.getChildAt(j);
            if (((localView instanceof olz)) && (j != i)) {
              ((olz)localView).a();
            }
            j += 1;
            continue;
            i += 1;
            break;
          }
        }
      }
      return;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     omf
 * JD-Core Version:    0.7.0.1
 */