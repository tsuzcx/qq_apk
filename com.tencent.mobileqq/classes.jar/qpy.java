import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.canvas.GdtCanvasData;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormComponentData;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormError;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormListener;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasDMPReportUtil;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;

public class qpy
{
  public static void a(GdtCanvasData paramGdtCanvasData, GdtCanvasFormComponentData paramGdtCanvasFormComponentData, WeakReference paramWeakReference)
  {
    if ((paramWeakReference != null) && (paramWeakReference.get() != null)) {
      ((GdtCanvasFormListener)paramWeakReference.get()).h();
    }
    ThreadManager.post(new qpz(paramGdtCanvasData, paramGdtCanvasFormComponentData, paramWeakReference), 5, null, true);
  }
  
  private static GdtCanvasFormError b(GdtCanvasData paramGdtCanvasData, GdtCanvasFormComponentData paramGdtCanvasFormComponentData)
  {
    Object localObject;
    if ((paramGdtCanvasData == null) || (!paramGdtCanvasData.isValid()) || (paramGdtCanvasFormComponentData == null) || (!paramGdtCanvasFormComponentData.isValid()))
    {
      GdtLog.d("GdtCanvasFormCommitUtil", "commit error");
      localObject = new GdtCanvasFormError(4, -1, null);
    }
    GdtCanvasFormError localGdtCanvasFormError;
    do
    {
      do
      {
        return localObject;
        localGdtCanvasFormError = qql.a(paramGdtCanvasData, paramGdtCanvasFormComponentData);
        localObject = localGdtCanvasFormError;
      } while (localGdtCanvasFormError == null);
      localObject = localGdtCanvasFormError;
    } while (localGdtCanvasFormError.a != 1);
    GdtCanvasDMPReportUtil.a(paramGdtCanvasData, paramGdtCanvasFormComponentData);
    return localGdtCanvasFormError;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qpy
 * JD-Core Version:    0.7.0.1
 */