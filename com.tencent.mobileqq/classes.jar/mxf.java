import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.wtogether.data.ReqVideoAction;
import com.tencent.av.wtogether.data.WTFileInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class mxf
  implements myk
{
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private mxd jdField_a_of_type_Mxd;
  private myj jdField_a_of_type_Myj;
  private final myt jdField_a_of_type_Myt = new myt();
  private naf jdField_a_of_type_Naf;
  private boolean jdField_a_of_type_Boolean;
  
  public mxf(VideoAppInterface paramVideoAppInterface, boolean paramBoolean, myj parammyj)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    a(paramBoolean, "WTogetherMngHelper");
    this.jdField_a_of_type_Myj = parammyj;
    this.jdField_a_of_type_Naf = parammyj.a();
    this.jdField_a_of_type_Mxd = ((mxd)paramVideoAppInterface.a(15));
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Myj.a();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Myj.a();
  }
  
  public void a(float paramFloat)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    lfe locallfe = lbz.a().a();
    long l1 = AudioHelper.b();
    int i = this.jdField_a_of_type_Myt.a();
    long l2 = a();
    paramFloat = a();
    this.jdField_a_of_type_Myt.a(i, l2, paramFloat);
    this.jdField_a_of_type_Mxd.a(locallfe, this.jdField_a_of_type_Myt);
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.MngHelper", 4, "onPlayRatioValueChange, seq[" + l1 + "], action[" + 4 + "], curPlayState[" + i + "], curPlayTimeMs[" + l2 + "], curPlayRate[" + paramFloat + "]");
    }
    ReqVideoAction localReqVideoAction = new ReqVideoAction(l1, 4, this.jdField_a_of_type_Myt);
    this.jdField_a_of_type_Mxd.a(locallfe, localReqVideoAction);
    mrr.a("0X800B635", 0, 0, "", "", "", "");
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Myj.a();
    if ((QLog.isDevelopLevel()) && (localObject != null)) {
      QLog.i("WTogether.MngHelper", 4, "onVideoPrepared, " + ((WTFileInfo)localObject).toString() + "]");
    }
    localObject = lbz.a().a();
    mxb.a(this.jdField_a_of_type_Mxd.a((lfe)localObject), paramInt);
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    long l = AudioHelper.b();
    this.jdField_a_of_type_Myt.a(0, a(), a());
    this.jdField_a_of_type_Mxd.a((lfe)localObject, this.jdField_a_of_type_Myt);
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.MngHelper", 4, "onPlayVideo, seq[" + l + "]");
    }
    ReqVideoAction localReqVideoAction = new ReqVideoAction(l, 0, this.jdField_a_of_type_Myt);
    this.jdField_a_of_type_Mxd.a((lfe)localObject, localReqVideoAction);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    lfe locallfe = lbz.a().a();
    paramInt2 = this.jdField_a_of_type_Myt.a();
    this.jdField_a_of_type_Myt.a(paramInt2, paramInt1, a());
    this.jdField_a_of_type_Mxd.a(locallfe, this.jdField_a_of_type_Myt);
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {}
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.MngHelper", 2, "updateAdminFlag, [" + this.jdField_a_of_type_Boolean + "-->" + paramBoolean + "], from[" + paramString + "]");
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    return false;
  }
  
  public boolean a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return false;
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    long l = AudioHelper.b();
    lfe locallfe = lbz.a().a();
    this.jdField_a_of_type_Myt.a(1, a(), a());
    this.jdField_a_of_type_Mxd.a(locallfe, this.jdField_a_of_type_Myt);
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.MngHelper", 4, "onPausePlay, seq[" + l + "]");
    }
    ReqVideoAction localReqVideoAction = new ReqVideoAction(l, 1, this.jdField_a_of_type_Myt);
    this.jdField_a_of_type_Mxd.a(locallfe, localReqVideoAction);
    mrr.a("0X800B634", 0, 0, "", "", "", "");
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    long l = AudioHelper.b();
    lfe locallfe = lbz.a().a();
    this.jdField_a_of_type_Myt.a(0, a(), a());
    this.jdField_a_of_type_Mxd.a(locallfe, this.jdField_a_of_type_Myt);
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.MngHelper", 4, "onResumePlay, seq[" + l + "]");
    }
    ReqVideoAction localReqVideoAction = new ReqVideoAction(l, 0, this.jdField_a_of_type_Myt);
    this.jdField_a_of_type_Mxd.a(locallfe, localReqVideoAction);
  }
  
  public void e()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    lfe locallfe = lbz.a().a();
    int i = 2;
    long l2 = AudioHelper.b();
    long l3 = a();
    Object localObject = this.jdField_a_of_type_Mxd.a(locallfe);
    if (localObject == null) {}
    for (long l1 = 0L;; l1 = ((myv)localObject).a)
    {
      if (l3 < l1) {
        i = 3;
      }
      int j = this.jdField_a_of_type_Myt.a();
      this.jdField_a_of_type_Myt.a(j, l3, a());
      this.jdField_a_of_type_Mxd.a(locallfe, this.jdField_a_of_type_Myt);
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.MngHelper", 4, "onSeekComplete, seq[" + l2 + "], action[" + i + "], last[" + l1 + "], cur[" + l3 + "]");
      }
      localObject = new ReqVideoAction(l2, i, this.jdField_a_of_type_Myt);
      this.jdField_a_of_type_Mxd.a(locallfe, (ReqVideoAction)localObject);
      mrr.a("0X800B633", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.MngHelper", 4, "onCompletion");
    }
    lfe locallfe = lbz.a().a();
    mxb.a(this.jdField_a_of_type_Mxd.a(locallfe), "onCompletion");
    mrr.a("0X800B639", 0, 0, "", "", "", "");
    if (!this.jdField_a_of_type_Boolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mxf
 * JD-Core Version:    0.7.0.1
 */