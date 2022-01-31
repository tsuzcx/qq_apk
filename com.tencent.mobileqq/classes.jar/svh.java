import com.tencent.mobileqq.app.QQAppInterface;

class svh
  extends sgc
{
  svh(svc paramsvc) {}
  
  public void a()
  {
    urk.b(svc.b(), "msg: MSG_ON_STORY_MSGTAB_DATA_LOADED");
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      urk.e(svc.b(), "[ERROR] onMsgTabStoryDataLoaded() app is null!");
    }
    stf localstf = (stf)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251);
    if (localstf.a()) {
      if (this.a.a()) {
        this.a.jdField_a_of_type_Suo.a("exp_story", 3);
      }
    }
    do
    {
      do
      {
        return;
        if (!localstf.b()) {
          break;
        }
      } while (!this.a.a());
      this.a.jdField_a_of_type_Suo.a("exp_story", 2);
      return;
      if (!this.a.jdField_a_of_type_Svm.a()) {
        break;
      }
    } while (!this.a.a());
    this.a.jdField_a_of_type_Suo.a("exp_story", 5);
    return;
    if (localstf.c())
    {
      this.a.h();
      localstf.a();
      this.a.jdField_a_of_type_Suo.a("exp_hide", 0);
      return;
    }
    this.a.jdField_a_of_type_Suo.a("exp_hide", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svh
 * JD-Core Version:    0.7.0.1
 */