package kotlin.reflect.jvm.internal.impl.builtins.jvm;

 enum JvmBuiltInsSettings$JDKMemberStatus
{
  static
  {
    JDKMemberStatus localJDKMemberStatus1 = new JDKMemberStatus("BLACK_LIST", 0);
    BLACK_LIST = localJDKMemberStatus1;
    JDKMemberStatus localJDKMemberStatus2 = new JDKMemberStatus("WHITE_LIST", 1);
    WHITE_LIST = localJDKMemberStatus2;
    JDKMemberStatus localJDKMemberStatus3 = new JDKMemberStatus("NOT_CONSIDERED", 2);
    NOT_CONSIDERED = localJDKMemberStatus3;
    JDKMemberStatus localJDKMemberStatus4 = new JDKMemberStatus("DROP", 3);
    DROP = localJDKMemberStatus4;
    $VALUES = new JDKMemberStatus[] { localJDKMemberStatus1, localJDKMemberStatus2, localJDKMemberStatus3, localJDKMemberStatus4 };
  }
  
  private JvmBuiltInsSettings$JDKMemberStatus() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings.JDKMemberStatus
 * JD-Core Version:    0.7.0.1
 */