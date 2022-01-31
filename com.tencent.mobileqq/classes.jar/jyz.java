import com.tencent.av.ui.QAVPtvTemplateAdapter;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.av.ui.QavListItemBase.IClickCallback;
import com.tencent.qphone.base.util.QLog;

public class jyz
  implements QavListItemBase.IClickCallback
{
  public jyz(QAVPtvTemplateAdapter paramQAVPtvTemplateAdapter) {}
  
  public void a(int paramInt, QavListItemBase paramQavListItemBase)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QAVPtvTemplateAdapter", 2, "PtvTemplateAdapter onItemClicked position: " + paramInt);
    }
    if ((System.currentTimeMillis() - this.a.a < 500L) && (paramInt > 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QAVPtvTemplateAdapter", 2, "PtvTemplateAdapter onItemClicked position yes : " + paramInt);
    }
    this.a.a = System.currentTimeMillis();
    int i = this.a.c;
    this.a.c = paramInt;
    this.a.a(i, this.a.c);
    this.a.a(this.a.c);
    this.a.c(this.a.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jyz
 * JD-Core Version:    0.7.0.1
 */