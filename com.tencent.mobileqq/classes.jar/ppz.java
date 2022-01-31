import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSImageView;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.PTSNodeStyle;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSTimeCostUtil;
import com.tencent.qphone.base.util.QLog;

public class ppz
  extends PTSNodeVirtual<PTSImageView>
{
  public final String a = "PTSNodeImage";
  
  private ppz(PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance);
  }
  
  private String a(String paramString)
  {
    int i = getNodeInfo().getStyle().getWidth();
    int j = getNodeInfo().getStyle().getHeight();
    String str = paramString;
    if (i > 0)
    {
      str = paramString;
      if (j > 0) {
        str = onh.a(paramString, i, j);
      }
    }
    return str;
  }
  
  private void a(String paramString)
  {
    PTSTimeCostUtil.start("image-" + paramString);
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http")) || (paramString.startsWith("pubaccount"))))
    {
      String str = a(paramString);
      PTSLog.i("PTSNodeImage", "[setImageSrc], cropUrl = " + str);
      ((PTSImageView)getView()).setImageSrc(str);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PTSNodeImage", 2, "[setImageSrc], path = " + paramString);
    }
    PTSTimeCostUtil.end("image-" + paramString);
  }
  
  public PTSImageView a()
  {
    return new PTSImageView(this);
  }
  
  public void resetAll() {}
  
  public boolean setAttribute(String paramString, Object paramObject)
  {
    if (super.setAttribute(paramString, paramObject)) {
      return true;
    }
    if (("src".equals(paramString)) && ((paramObject instanceof String)))
    {
      a((String)paramObject);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ppz
 * JD-Core Version:    0.7.0.1
 */