final class rnm
  extends rnk<rnp, rno, rnn>
{
  public void a(rnp paramrnp, rno paramrno, int paramInt, rnn paramrnn)
  {
    switch (paramInt)
    {
    default: 
      paramrnp.a(paramrno);
      return;
    case 1: 
      paramrnp.a(paramrno, paramrnn.a, paramrnn.b);
      return;
    case 2: 
      paramrnp.b(paramrno, paramrnn.a, paramrnn.b);
      return;
    case 3: 
      paramrnp.a(paramrno, paramrnn.a, paramrnn.c, paramrnn.b);
      return;
    }
    paramrnp.c(paramrno, paramrnn.a, paramrnn.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rnm
 * JD-Core Version:    0.7.0.1
 */