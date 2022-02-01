import com.tencent.qphone.base.util.QLog;
import java.util.List;

class pxr
  implements pxi<BEAN>
{
  pxr(pxp parampxp) {}
  
  public void a(boolean paramBoolean, List<BEAN> paramList, int paramInt, String paramString)
  {
    if (pxp.a(this.a) != null)
    {
      if (!paramBoolean) {
        break label69;
      }
      pxp.a(this.a).setListData(paramList, true);
      if (pxp.a(this.a).a()) {
        pxp.a(this.a).setFooterHasMore();
      }
    }
    else
    {
      return;
    }
    pxp.a(this.a).setFooterNoMore();
    return;
    label69:
    QLog.i("ListPresenter", 2, "loadNextPage error, errorCode=" + paramInt + ", errorMsg= " + paramString);
    pxp.a(this.a).setFooterError(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pxr
 * JD-Core Version:    0.7.0.1
 */