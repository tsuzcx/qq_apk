import com.tribe.async.reactive.StreamFunction;

class tfs
  extends StreamFunction<tfi, tfi>
{
  int jdField_a_of_type_Int = 0;
  
  tfs(tfn paramtfn) {}
  
  protected void a(tfi paramtfi)
  {
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    veg.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] will fetch vidlist of uinion_id: %s", Integer.valueOf(i), paramtfi.a);
    notifyResult(paramtfi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tfs
 * JD-Core Version:    0.7.0.1
 */