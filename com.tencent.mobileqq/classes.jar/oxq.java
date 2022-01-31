import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeVideoView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class oxq
{
  public static void a(View paramView)
  {
    if ((paramView instanceof oxk)) {
      ((oxk)paramView).a();
    }
  }
  
  public static void a(Container paramContainer)
  {
    paramContainer = paramContainer.getViewIdMapping().entrySet().iterator();
    while (paramContainer.hasNext())
    {
      Object localObject = (Map.Entry)paramContainer.next();
      if ((((Map.Entry)localObject).getValue() instanceof ply))
      {
        localObject = (ply)((Map.Entry)localObject).getValue();
        if ((((ply)localObject).a() instanceof NativeVideoView)) {
          ((ply)localObject).a().b();
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
    e(paramListView);
  }
  
  public static void b(Container paramContainer)
  {
    paramContainer = paramContainer.getViewIdMapping().entrySet().iterator();
    while (paramContainer.hasNext())
    {
      Object localObject = (Map.Entry)paramContainer.next();
      if ((((Map.Entry)localObject).getValue() instanceof ply))
      {
        localObject = (ply)((Map.Entry)localObject).getValue();
        if ((((ply)localObject).a() instanceof NativeVideoView)) {
          ((ply)localObject).a().b();
        }
      }
    }
  }
  
  public static void b(ListView paramListView)
  {
    if ((!onh.a(paramListView.getContext())) || (paramListView.getChildCount() <= 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramListView.getChildCount())
      {
        View localView = paramListView.getChildAt(i);
        if ((localView instanceof oxk)) {
          ((oxk)localView).b();
        }
        i += 1;
      }
    }
  }
  
  public static void c(ListView paramListView)
  {
    if ((!onh.a(paramListView.getContext())) || (paramListView.getChildCount() <= 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramListView.getChildCount())
      {
        View localView = paramListView.getChildAt(i);
        if ((localView instanceof oxk)) {
          ((oxk)localView).a();
        }
        i += 1;
      }
    }
  }
  
  public static void d(ListView paramListView)
  {
    if ((!onh.a(paramListView.getContext())) || (paramListView.getChildCount() <= 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramListView.getChildCount())
      {
        View localView = paramListView.getChildAt(i);
        if ((localView instanceof oxk)) {
          ((oxk)localView).c();
        }
        i += 1;
      }
    }
  }
  
  private static void e(ListView paramListView)
  {
    int j = 0;
    int i = 0;
    View localView;
    if (i < paramListView.getChildCount())
    {
      localView = paramListView.getChildAt(i);
      if (((localView instanceof oxk)) && (omr.a(localView) >= 60.0F))
      {
        QLog.d("gifvideo.VideoPlayControlUtils", 2, ">= 60f");
        if (!((oxk)localView).a()) {}
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
            if (((localView instanceof oxk)) && (j != i)) {
              ((oxk)localView).a();
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
 * Qualified Name:     oxq
 * JD-Core Version:    0.7.0.1
 */