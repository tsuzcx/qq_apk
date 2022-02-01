import com.tencent.qphone.base.util.QLog;

class nhm
  extends nrn
{
  nhm(nhk paramnhk) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameResultPKPresenterImp", 2, String.format("onSurvivalPoolEnter isSuc:%b errCode:%d msg:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramString }));
    }
    this.a.a.b(nfc.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nhm
 * JD-Core Version:    0.7.0.1
 */