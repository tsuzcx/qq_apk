package okhttp3.internal.http2;

final class Huffman$Node
{
  final Node[] children;
  final int symbol;
  final int terminalBits;
  
  Huffman$Node()
  {
    this.children = new Node[256];
    this.symbol = 0;
    this.terminalBits = 0;
  }
  
  Huffman$Node(int paramInt1, int paramInt2)
  {
    this.children = null;
    this.symbol = paramInt1;
    paramInt2 &= 0x7;
    paramInt1 = paramInt2;
    if (paramInt2 == 0) {
      paramInt1 = 8;
    }
    this.terminalBits = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.http2.Huffman.Node
 * JD-Core Version:    0.7.0.1
 */