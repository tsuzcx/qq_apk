import UserGrowth.stBlockRecommPersonRsp;

class teq
  implements tgt
{
  teq(tep paramtep) {}
  
  public void a(the paramthe)
  {
    if (!(paramthe.a instanceof stBlockRecommPersonRsp)) {
      tlo.b("WSUserBusiness", "[actionBlockRecommendPerson] data error: " + paramthe.a);
    }
    do
    {
      return;
      paramthe = (stBlockRecommPersonRsp)paramthe.a;
    } while (paramthe == null);
    tlo.b("WSUserBusiness", "[actionBlockRecommendPerson] data success resultBean.ret:" + paramthe.ret);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     teq
 * JD-Core Version:    0.7.0.1
 */